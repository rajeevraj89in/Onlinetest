import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {

  qId: any;
  questions: any;

  marksGot = 0;
  correctAnswers = 0;
  attempted = 0;
  isSubmit = false;

  constructor(private locationSt: LocationStrategy, private _route: ActivatedRoute, private _question: QuestionService) { }

  ngOnInit(): void {
    this.preventBackButton();
    this.qId = this._route.snapshot.params.qid;
    this.loadQuestion();
  }

  preventBackButton() {
    history.pushState(null, '', location.href);
    this.locationSt.onPopState(() => {
      history.pushState(null, '', location.href);
    });
  }

  loadQuestion() {
    this._question.getQuestionsOfQuizForTest(this.qId).subscribe(
      (data: any) => {
        this.questions = data;
        this.questions.forEach((q: any) => {
          q['givenAnswer'] = '';
        });
        // console.log(data);
      },
      (error) => {
        Swal.fire("Error", "Error in loading questions", 'error');
      }
    );
  }

  submitQuiz() {
    this.isSubmit = true;
    Swal.fire({
      title: 'Do you want to submit the quiz?',
      showCancelButton: true,
      confirmButtonText: "Submit",
      icon: 'info'
    }).then((result) => {
      if (result.isConfirmed) {
        this.questions.forEach((q: any) => {
          if (q.givenAnswer == q.answer) {
            this.correctAnswers++;
            let marksSingle = this.questions[0].quiz.maxMarks / this.questions.length;
            this.marksGot += marksSingle;
          }
          if (q.givenAnswer.trim() != '') {
            this.attempted++;
          }
        });
      }
    });
  }

}
