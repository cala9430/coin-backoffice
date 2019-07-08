import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../domain/user";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.less']
})
export class UserListComponent implements OnInit {

  constructor(private userService: UserService) { }

  private _users: Array<User>;

  get users(): Array<User> {
    return this._users;
  }

  ngOnInit() {
    this.userService.listUsers().subscribe(list => {
      this._users = list;
    });
  }

}
