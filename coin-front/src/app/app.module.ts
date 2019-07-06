import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './component/app.component';
import { UserViewComponent } from './component/user-view/user-view.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import { WalletViewComponent } from './component/wallet-view/wallet-view.component';

@NgModule({
  declarations: [
    AppComponent,
    UserViewComponent,
    WalletViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'user/:id', component: UserViewComponent }
      ],

      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
