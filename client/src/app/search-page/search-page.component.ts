import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {
  employeeSearchForm: FormGroup;
  constructor(private fb: FormBuilder) { }

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
  }
}
