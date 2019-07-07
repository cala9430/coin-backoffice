import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../service/user.service";
import {User} from "../../domain/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.less']
})
export class UserCreateComponent implements OnInit {
  options: FormGroup = new FormGroup({
    email : new FormControl('', [Validators.required, Validators.email]),
    name : new FormControl('', [Validators.required])
  });

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit() {
  }

  getErrorMessage(name:string) {
    return this.options.get(name).hasError('required') ? 'You must enter a value' :
      this.options.get(name).hasError('email') ? 'Not a valid email' :
        '';
  }

  createUser(){
    let newUser : User = {
      id: null,
      name: this.options.get("name").value,
      email: this.options.get("email").value,
      wallets: null
    };
    this.userService.createUser(newUser).subscribe( newUser => {
      this.router.navigateByUrl("/user/"+newUser.id);
    }, error => {
      console.error("user creation failed")
    });
  }
}
