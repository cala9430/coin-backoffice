import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {WalletService} from "../../service/wallet.service";
import {Wallet} from "../../domain/wallet";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-wallet-transfer',
  templateUrl: './wallet-transfer.component.html',
  styleUrls: ['./wallet-transfer.component.less']
})
export class WalletTransferComponent implements OnInit {

  private _wallet : Wallet;

  options: FormGroup = new FormGroup({
    to : new FormControl('', [Validators.required]),
    amount : new FormControl('', [Validators.required, Validators.min(0.01)])
  });

  constructor(private walletService: WalletService, private router: ActivatedRoute) {

  }

  get wallet(): Wallet {
    return this._wallet;
  }

  ngOnInit() {
    this.router.paramMap.subscribe(paramMap => {
      this.walletService.getWallet(paramMap.get("id")).subscribe((value:Wallet) => {this._wallet = value});
    });
  }

  doTransfer(){
    this.walletService.doTransfer(this._wallet.id, this.options.get("to").value, this.options.get("amount").value)
      .subscribe(value => {
      this._wallet = value;
    })
  }

  getErrorMessage(name:string) {
    return this.options.get(name).hasError('required') ? 'You must enter a value' :
      this.options.get(name).hasError('min') ? 'Must be greater than 0.01' :
        '';
  }

}
