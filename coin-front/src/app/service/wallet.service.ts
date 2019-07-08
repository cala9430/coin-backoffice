import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Wallet} from "../domain/wallet";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  addWalletToUser(userId: string):Observable<Wallet>{
    return this.http.put<Wallet>(this.baseUrl + "wallets?userId=" + userId, {});
  }

  getWallet(id: string): Observable<Wallet>{
    return this.http.get<Wallet>(this.baseUrl + "wallets/" + id);
  }

  doTransfer(id: string, to:string, amount:number):Observable<Wallet>{
    return  this.http.post<Wallet>(this.baseUrl + "wallets/" + id, {to:to, amount:amount});
  }



}
