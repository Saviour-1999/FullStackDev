import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostBean
{
  
}
export class WelcomeService {

  constructor(
    private http: HttpClient
  ) { }

  executeWelcomeMessageService()
  {
    console.log("executeWelcomeMessageService")
    return this.http.get('http://localhost:8080/post/viewPost');
  }
}
