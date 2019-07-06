import {Component, Input, OnInit} from '@angular/core';
import {Wallet} from "../../domain/wallet";

@Component({
  selector: 'app-wallet-view',
  templateUrl: './wallet-view.component.html',
  styleUrls: ['./wallet-view.component.less']
})
export class WalletViewComponent implements OnInit {

  constructor() { }

  @Input("wallet")
  private _wallet: Wallet;

  ngOnInit() {
  }

  get wallet(): Wallet {
    return this._wallet;
  }
}
