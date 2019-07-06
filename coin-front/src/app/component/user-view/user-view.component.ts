import { Component, OnInit } from '@angular/core';
import {User} from "../../domain/user";
import {UserService} from "../../service/user.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.less']
})
export class UserViewComponent implements OnInit {

  constructor(private userService: UserService, private router: ActivatedRoute) { }

  private _user : User;

  get user(): User {
    return this._user;
  }

ngOnInit() {
    this.router.paramMap.subscribe(paramMap => {
      this.userService.getUser(paramMap.get("id")).subscribe((value:User) => {this._user = value});
    });
  }

}
