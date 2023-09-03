import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { PostgridComponent } from './postgrid/postgrid.component';
import { PostdetailsComponent } from './postdetails/postdetails.component';
import { ErrorComponent } from './error/error.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HttpIntercepterJWTAuthService } from './service/http/http-intercepter-jwtauth.service';
import { LogoutComponent } from './logout/logout.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UserCreateComponent } from './user-create/user-create.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    PostgridComponent,
    PostdetailsComponent,
    ErrorComponent,
    HeaderComponent,
    FooterComponent,
    LogoutComponent,
    CreatePostComponent,
    UserCreateComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterJWTAuthService, multi : true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
