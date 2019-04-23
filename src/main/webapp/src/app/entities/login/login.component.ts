import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginUser = {};
  constructor(private authService:AuthService,
              private router : Router) { }

  ngOnInit() {
  }

  login(usernameOrEmail, password){
    console.log(this.loginUser);
    console.log("Username : "+ usernameOrEmail);
    console.log("password : "+ password);
    this.authService.login(usernameOrEmail, password ).subscribe(
      res => {
        console.log(res)
        localStorage.setItem('token', res.accessToken)
        this.router.navigate(['/employees'])
    },
      err => {
        console.log(err)
        if(err instanceof HttpErrorResponse){
          if(err.status === 401){
            console.log("Invalid Crediantials...!!!")
          }
        }
      }
    )
  }

}
