import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  public Editor: any = ClassicEditor;

  qId = null;
  title = null;
  question: any = {
    quiz: {
    },
    content: '',
    option1: '',
    option2: '',
    option3: '',
    option4: '',
    answer: ''
  };

  constructor(private _route: ActivatedRoute, private _question: QuestionService, private _router: Router) { }

  ngOnInit(): void {
    this.qId = this._route.snapshot.params.qId;
    this.title = this._route.snapshot.params.title;
    this.question.quiz['qId'] = this.qId;
    this.question.quiz['title'] = this.title;
  }

  addQuestion() {
    this._question.addQuestion(this.question).subscribe(
      (data: any) => {
        Swal.fire('Success', 'Question Added Successfully', 'success');
        this.question = {
          quiz: {
          },
          content: '',
          option1: '',
          option2: '',
          option3: '',
          option4: '',
          answer: ''
        };
        // this._router.navigate(['admin/view-questions/:qId/:title']);
      },
      (error) => {
        Swal.fire('Error', 'Server Error', 'error');
        console.log(error);
      }
    );
  }

}
