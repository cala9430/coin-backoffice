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
        {path: 'user/:id', component: UserViewComponent},
        {path: 'user/:id/history', component: UserHistoryComponent}
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
