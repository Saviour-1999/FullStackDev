import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL, BITTER_API_URL } from '../app.constants';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

export const TOKEN = ''
export const AUTHENTICATED_USER = 'authenticaterUser'
@Injectable({
  providedIn: 'root'
})
export class JwtAuthenticationService {

  constructor(private http: HttpClient, private router: Router) { }

  executeJWTAuthenticationService(username: string,password: string)
  {
    var OGUserName = username;
    this.executeSpringAuthentication(username,password).subscribe(
      response =>
      {
        let isAuthenticated: boolean= response;
        this.executeJWTAuthenticationFake(username,password,OGUserName,isAuthenticated).subscribe(
          data => {
            console.log(data)
            this.router.navigate(['posts'])
          },
          error => {
            console.log(error)
            this.router.navigate(['error']);
          }
        )
      }
    )

  }

  executeSpringAuthentication(username: string,password: string)
  {
    return this.http.post<boolean>(`${API_URL}/user/Authenticate`,{
      username,
      password
    })
  }

  executeJWTAuthenticationFake(username:string, password:string, OGUserName: string,isAuthenticated: boolean)
  {
    if(isAuthenticated === true)
    {
      username='in28minutes';
      password= 'dummy';
      console.log("4");
    }
        
    return this.http.post<any>(
      `${API_URL}/authenticate`,{
      username,
      password
      }).pipe(
        map(
          data=>{
            sessionStorage.setItem(AUTHENTICATED_USER, OGUserName);
            sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
            return data;
          }
        )
      )
  }
  
  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER)
  }

  getAuthenticatedToken() {
    if (this.getAuthenticatedUser())
      return sessionStorage.getItem(TOKEN)
    return null
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATED_USER)
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER)
    sessionStorage.removeItem(TOKEN)
  }

}

export class AuthenticationBean {
  constructor(public message: string) { }
}
