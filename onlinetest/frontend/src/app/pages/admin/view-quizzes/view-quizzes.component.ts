import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit {

  quizzes: any = [];

  constructor(private _quiz: QuizService) { }

  ngOnInit(): void {
    this._quiz.quizzes().subscribe(
      (data: any) => {
        this.quizzes = data;
        console.log(this.quizzes);
      },
      (error) => {
        Swal.fire("Error!!", 'Server Error', 'error');
      }
    );
  }

  deleteQuiz(qId: any) {

    Swal.fire({
      icon: 'info',
      title: "Are you sure",
      confirmButtonText: "Delete",
      showCancelButton: true,
    }).then((result: any) => {
      if (result.isConfimed) {
        this._quiz.deleteQuiz(qId).subscribe(
          (data: any) => {
            Swal.fire("Success", "Quiz Deleted Successfully", 'success');
            this.quizzes = this.quizzes.filter((quiz: any) => quiz.qId != qId);
          },
          (error) => {
            Swal.fire("Error", "Server Error", 'error');
          }
        );
      }
    });
  }

}
