import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EmployeeService } from '../services/employee.service';


@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {
  employeeSearchForm: FormGroup;
  constructor(private fb: FormBuilder, private employeeService: EmployeeService) { }

  genderList = [{ key: 'Female', value: "F" }, { key: 'Male', value: "M" }];
  hireDate: any;

  ngOnInit(): void {
    this.employeeSearchForm = this.fb.group({
      employeeId: [{ value: '', disabled: false }, []],
      firstName: [{ value: '', disabled: false }, []],
      lastName: [{ value: '', disabled: false }, []],
      email: [{ value: '', disabled: false }, []],
      hireDate: [null, []],
      gender: [{ value: '', disabled: false }, []]
    });
  }

  searchEmployees() {
    console.log("employee search params : ", this.employeeSearchForm.value);
    this.employeeService.filterEmployees(this.employeeSearchForm.value).subscribe(
      result => {
        console.log('result emp list : ', result['empList']);
        console.log('result count : ', result['totalEmps']);
      },
      error => {
        console.log('error while filter emp list : ', error);
      })
  }
}
