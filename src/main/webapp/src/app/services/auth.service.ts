import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppSettings } from '../shared/app-settings';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient,
              private router : Router) { }

  login(usernameOrEmail, password ){
    return this.http.post<any>(AppSettings.API_ENDPOINT +"/auth/signin", { usernameOrEmail, password });
  }

  loggedIn(){
    return !!localStorage.getItem('token');
  }

  getToken(){
    return localStorage.getItem('token');
  }

  logout(){
    localStorage.removeItem('token');
    this.router.navigate(['/login'])
  }
}
