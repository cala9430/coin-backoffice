import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../service/user.service";
import {Transaction} from "../../domain/transaction";

@Component({
  selector: 'app-user-history',
  templateUrl: './user-history.component.html',
  styleUrls: ['./user-history.component.less']
})
export class UserHistoryComponent implements OnInit {

  constructor(private userService: UserService, private router:ActivatedRoute) { }

  private _transactions:Array<Transaction>;

  private _userId: string;

  get transactions(): Array<Transaction> {
    return this._transactions;
  }

  get userId(): string {
    return this._userId;
  }

  ngOnInit() {
    this.router.paramMap.subscribe(paramMap => {
      this._userId = paramMap.get("id");
      this.userService.getUserHist(this._userId).subscribe((value:Array<Transaction>) => {this._transactions = value});
    });
  }

}
