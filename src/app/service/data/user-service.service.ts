import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';
import { User } from 'src/app/user-create/user-create.component';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  addUserService(user: User)
  {
    return this.http.post(`${API_URL}/user/create`,user,{responseType: 'text'});
  }
}
