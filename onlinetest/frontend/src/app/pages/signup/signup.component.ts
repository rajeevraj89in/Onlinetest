import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private snack: MatSnackBar) { }

  public user = {
    username: '',
    password: '',
    firstname: '',
    lastname: '',
    email: '',
    phone: ''
  }

  ngOnInit(): void {
  }

  formSubmit() {
    // alert("Submit");
    // console.log(this.user);
    this.userService.addUser(this.user).subscribe(
      (data) => {
        // success
        console.log(data);
        // alert("Success");
        this.snack.open("Success", '', {
          duration: 3000,
          verticalPosition: 'top',
          horizontalPosition: 'center'
        });
        Swal.fire('Success', 'Registration Successfull', 'success');
      },
      (error) => {
        // error
        console.log(error);
        //alert("Something went wrong");
        this.snack.open("Something went wrong", '', {
          duration: 3000,
          verticalPosition: 'top',
          horizontalPosition: 'center'
        });
        Swal.fire('Error', 'Registration Failed', 'error');
      }
    );
  }

}
