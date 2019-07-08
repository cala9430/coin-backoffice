import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../domain/user";
import {UserService} from "../../service/user.service";
import {ActivatedRoute} from "@angular/router";
import {WalletService} from "../../service/wallet.service";

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.less']
})
export class UserViewComponent implements OnInit {

  constructor(private userService: UserService, private walletService: WalletService, private router: ActivatedRoute) { }

  @Input("user")
  private _user : User;

  get user(): User {
    return this._user;
  }

ngOnInit() {
    if(!this._user){
      this.router.paramMap.subscribe(paramMap => {
        this.userService.getUser(paramMap.get("id")).subscribe((value:User) => {this._user = value});
      });
    }
  }

  addWallet(){
    this.walletService.addWalletToUser(this._user.id).subscribe(wallet=> {
      this._user.wallets = this._user.wallets.concat(wallet);

    }, error1 => console.error(error1));
  }

}
