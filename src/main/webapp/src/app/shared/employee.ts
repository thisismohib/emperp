export class Employee {
    id:number;
	employeeId:string;
	firstName:string;
	lastName:string;
	mobileNo:number;
	email:string;
	active:number;
	role:string;
    approved:boolean;
    
    constructor(id:number, employeeId:string, firstName:string, lastName:string, mobileNo:number,
        email :string, active :number, role :string, approved:boolean){
        this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.active = active;
		this.role = role;
		this.approved = approved;
    }
}
