import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AlertModule } from 'ngx-bootstrap';
import { NavbarComponent } from './entities/navbar/navbar.component';
import { HomeComponent } from './entities/home/home.component';
import { LoginComponent } from './entities/login/login.component';
import { SignupComponent } from './entities/signup/signup.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { EmployeesComponent } from './entities/employees/employees.component';
import { AuthService } from './services/auth.service';
import { EmployeeService } from './services/employees/employee.service';
import { AuthGuard } from './services/auth.guard';
import { TokenInterceptorService } from './services/token-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    EmployeesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService, EmployeeService, AuthGuard,
  {provide : HTTP_INTERCEPTORS, useClass : TokenInterceptorService, multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
