import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

export class country {
  id: string;
  countryName: string;

  constructor(id: string, countryName: string) {
    this.id = id;
    this.countryName = countryName;
  }
}

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {
  contactForm = new FormGroup({
    email:new FormControl('',[Validators.email,Validators.required]),
    password:new FormControl('', [Validators.required, Validators.maxLength(6)]),
    passwordCf:new FormControl('', [Validators.required, Validators.maxLength(6)]),
    country: new FormControl('',[Validators.required]),
    age: new FormControl('',[Validators.required, Validators.min(18)]),
    gender: new FormControl('',[Validators.required]),
    phone: new FormControl('', [Validators.required,
      Validators.maxLength(10), Validators.pattern("^\\+84\\d{9,10}$")])
  })

  get email() {
    return this.contactForm.get('email');
  }
  get password() {
    return this.contactForm.get('password');
  }
  get passwordCf() {
    return this.contactForm.get('passwordCf');
  }
  get country() {
    return this.contactForm.get('country');
  }
  get age() {
    return this.contactForm.get('age');
  }
  get gender() {
    return this.contactForm.get('gender');
  }
  get phone() {
    return this.contactForm.get('phone');
  }

  countryList: country[] = [
    new country("1", "VietNam"),
    new country("3","US"),
    new country("4","England"),
    new country("5","Wale"),
    new country("6","FindLand"),
    new country("7","Canada"),
  ];

  confirmPassword(){
    let psw = this.password.value;
    if (psw === this.passwordCf.value){
      return null;
    } else {
      return "confirmPassword";
    }
  }

  onSubmit(){
    console.log(this.contactForm.value);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
