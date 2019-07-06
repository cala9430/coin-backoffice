import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './component/app.component';
import { UserViewComponent } from './component/user-view/user-view.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import { WalletViewComponent } from './component/wallet-view/wallet-view.component';
import { HeaderComponent } from './component/header/header.component';
import { UserCreateComponent } from './component/user-create/user-create.component';
import { UserHistoryComponent } from './component/user-history/user-history.component';

@NgModule({
  declarations: [
    AppComponent,
    UserViewComponent,
    WalletViewComponent,
    HeaderComponent,
    UserCreateComponent,
    UserHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'user/:id', component: UserViewComponent },
      { path: 'user/:id/history', component: UserHistoryComponent },
      { path: 'user/create', component: UserCreateComponent }
      ],

      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
