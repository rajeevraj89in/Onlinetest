import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {

  constructor(private _route: ActivatedRoute, private _question: QuestionService, private _snak: MatSnackBar) { }

  qId = null;
  title = null;
  questions: any = [];
  ngOnInit(): void {
    this.qId = this._route.snapshot.params.qId;
    this.title = this._route.snapshot.params.title;
    this._question.getQuestionOfQuiz(this.qId).subscribe(
      (data: any) => {
        this.questions = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  delete(qId: any) {
    //alert(qId);
    Swal.fire({
      icon: 'info',
      showCancelButton: true,
      confirmButtonText: 'Delete',
      title: 'Are you sure, Want to delete this question?',
    }).then((result) => {
      if (result.isConfirmed) {
        this._question.deleteQuestion(qId).subscribe(
          (data: any) => {
            this._snak.open('Question Deleted Successfully', '', {
              duration: 3000,
            });
            this.questions = this.questions.filter((q: any) => q.quesId != qId);
          },
          (error) => {
            this._snak.open('Unable to delete question', '', {
              duration: 3000,
            });
          }
        );
      }
    });
  }

}
