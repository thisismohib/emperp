import { Component, OnInit, Inject } from '@angular/core';
import { EmployeeService } from 'src/app/services/employees/employee.service';
import { Employee } from 'src/app/shared/employee';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  employees : Employee[] = [];
  msg : string;

  constructor(private employeeService:EmployeeService) { }

  ngOnInit() {
    console.log("ngOnInit() called")
    this.onGetAllClicked();
  }

  onGetAllClicked(){
    this.employeeService.getAll()
      .subscribe(
        data => this.employees = data,
        err => console.log(err)
    );
  }

  onDeleteClick(id : number){
    this.employeeService.delete(id).subscribe(data => {
      this.msg = data;
      alert(this.msg);
      this.onGetAllClicked();
    });
  }

}
