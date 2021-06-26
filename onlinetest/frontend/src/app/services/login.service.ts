import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<boolean>();

  constructor(private http: HttpClient) { }

  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`, loginData);
  }

  // Login User

  public loginuser(token: any) {
    localStorage.setItem('token', token);
    // this.loginStatusSubject.next(true);
    return true;
  }

  // Is user logged in

  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token");
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false;
    } else {
      return true;
    }
  }

  // Logout

  public logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  // Get Token

  public getToken() {
    return localStorage.getItem('token');
  }

  // Set Userdata

  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  // Get User

  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  // Get User Role

  public getUserRole() {
    let user = this.getUser();
    return user.authorities[0].authority;
  }

  // Get Current User

  public getCurrentUser() {
    return this.http.get(`${baseUrl}/current-user`);
  }

}
