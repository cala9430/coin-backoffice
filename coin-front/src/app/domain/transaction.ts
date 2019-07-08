import {Wallet} from "./wallet";

export class Transaction {
  from: Wallet;
  to:Wallet;
  amount: number;
}
