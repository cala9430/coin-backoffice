import {Wallet} from "./wallet";

export class User {
  id : string;
  name: string;
  email: string;
  wallets: Array<Wallet>;
}
