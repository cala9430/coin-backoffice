import {Wallet} from "./wallet";

export class User {
  id : number;
  name: string;
  email: string;
  wallets: Array<Wallet>;
}
