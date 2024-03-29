import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../domain/user";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Transaction} from "../domain/transaction";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  listUsers():Observable<Array<User>>{
    return this.http.get<Array<User>>(this.baseUrl + "users");
  }

  getUser(id:string):Observable<User>{
    return this.http.get<User>(this.baseUrl+"users/"+id);
  }

  createUser(user:User):Observable<User>{
    return this.http.put<User>(this.baseUrl + "users", user);
  }

  getUserHist(id: string): Observable<Array<Transaction>>{
    return this.http.get<Array<Transaction>>(this.baseUrl + "users/" + id + "/history");
  }
}
