import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtAuthenticationService, TOKEN } from '../jwt-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterJWTAuthService implements HttpInterceptor{

  constructor(private jwtAuthenticationService : JwtAuthenticationService) { }

  intercept(request : HttpRequest<any>, next: HttpHandler){
    let token = this.jwtAuthenticationService.getAuthenticatedToken();
    if(token)
    {
      request = request.clone({
        setHeaders:{
          Authorization: token
        }
      })
    }
    return next.handle(request);
  }
}
