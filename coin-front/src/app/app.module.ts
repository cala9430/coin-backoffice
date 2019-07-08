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
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatButtonModule, MatCardModule,
  MatFormFieldModule,
  MatIconModule, MatInputModule, MatListModule,
  MatMenuModule,
  MatSelectModule,
  MatToolbarModule
} from "@angular/material";
import {ReactiveFormsModule} from "@angular/forms";
import { UserSearchComponent } from './component/user-search/user-search.component';
import { WalletSearchComponent } from './component/wallet-search/wallet-search.component';
import { WalletTransferComponent } from './component/wallet-transfer/wallet-transfer.component';

@NgModule({
  declarations: [
    AppComponent,
    UserViewComponent,
    WalletViewComponent,
    HeaderComponent,
    UserCreateComponent,
    UserHistoryComponent,
    UserSearchComponent,
    WalletSearchComponent,
    WalletTransferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    ReactiveFormsModule,

    RouterModule.forRoot([
        {path: 'user/create', component: UserCreateComponent},
        {path: 'user/search', component: UserSearchComponent},
        {path: 'user/:id', component: UserViewComponent},
        {path: 'user/:id/history', component: UserHistoryComponent},
        {path: 'wallet/search', component: WalletSearchComponent},
        {path: 'wallet/:id/transfer', component: WalletTransferComponent},
        {path: 'wallet/:id', component: WalletViewComponent},

      ],

      {enableTracing: true} // <-- debugging purposes only
    ),
    MatCardModule,
    MatListModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
