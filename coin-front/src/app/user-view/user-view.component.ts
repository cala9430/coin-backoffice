import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.less']
})
export class UserViewComponent implements OnInit {

  constructor(private userService: UserService) { }

  private _user : User;

  get user(): User {
    return this._user;
  }

  ngOnInit() {
    this.userService.getUser("5d1ff152c81d8815fe9d5de0").subscribe((value:User) => {this._user = value});
  }

}
