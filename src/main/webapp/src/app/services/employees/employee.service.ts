import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppSettings } from 'src/app/shared/app-settings';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public EMPLOYEE_API = AppSettings.API_ENDPOINT + '/employees';

  constructor(private http:HttpClient) { }

  getAll(){
    return this.http.get<any>(this.EMPLOYEE_API);
  }


  get(id:number) {
    return this.http.get<any>(this.EMPLOYEE_API+ '/'+id);
  }

  save(employee: any): Observable<any> {
    let result: Observable<Object>;
    if (employee['href']) {
      result = this.http.put(employee.href, employee);
    } else {
      result = this.http.post(this.EMPLOYEE_API, employee);
    }
    return result;
  }

  delete(id: number) : Observable<any>{
    return this.http.delete(this.EMPLOYEE_API+ '/'+id, {responseType:"text"});
  }
}
