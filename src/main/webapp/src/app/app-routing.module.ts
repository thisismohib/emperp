import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './entities/login/login.component';
import { SignupComponent } from './entities/signup/signup.component';
import { HomeComponent } from './entities/home/home.component';
import { EmployeesComponent } from './entities/employees/employees.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:'', redirectTo :'/login',  pathMatch: 'full'},
  {path:'login', component:LoginComponent},
  {path:'signup', component:SignupComponent},
  {path:'home', component:HomeComponent, canActivate : [AuthGuard]},
  {path:'employees', component:EmployeesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
