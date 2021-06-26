import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isUserloggedIn = false;
  user: any = null;
  constructor(public login: LoginService) { }

  ngOnInit(): void {
    this.isUserloggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe(
      (data) => {
        this.isUserloggedIn = this.login.isLoggedIn();
        this.user = this.login.getUser();
      }
    );
  }

  logout() {
    this.login.logout();
    this.isUserloggedIn = false;
    this.user = null;
    window.location.reload();
  }

}
