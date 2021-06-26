import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {

  category: any = [];

  quiz = {
    title: '',
    description: '',
    maxMarks: '',
    numberOfQuestions: '',
    active: '',
    category: null
  };

  constructor(private _category: CategoryService, private _snack: MatSnackBar, private _quiz: QuizService) { }

  ngOnInit(): void {
    this._category.categories().subscribe(
      (data: any) => {
        this.category = data;
        console.log(this.category);
      },
      (error) => {
        console.log(error);
        Swal.fire("Error!!", 'Server Error', 'error');
      }
    );
  }

  addQuiz() {
    if (this.quiz.title.trim() == "" || this.quiz.title == null) {
      this._snack.open("Title Required", '', {
        duration: 3000,
      });
      return;
    }
    this._quiz.addQuiz(this.quiz).subscribe(
      (data: any) => {
        Swal.fire("Success", "Quiz is added successfully", 'success');
        this.quiz = {
          title: '',
          description: '',
          maxMarks: '',
          numberOfQuestions: '',
          active: '',
          category: null
        };
      },
      (error) => {
        Swal.fire("Error!!", 'Server Error', 'error');
        console.log(error);
      }
    );

  }

}
