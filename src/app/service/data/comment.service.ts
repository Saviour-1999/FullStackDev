import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';
import { Comments } from 'src/app/postdetails/postdetails.component';
import { Posts } from 'src/app/postgrid/postgrid.component';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http : HttpClient) { }

  showAllCommentsByPost_Id(params: HttpParams, post_id : string){
    return this.http.get<any>(`${API_URL}/comments/${post_id}`,{params});
  }

  addCommentService(comment :Comments){
    return this.http.post(`${API_URL}/comments/create`, comment, {responseType: 'text'});
  }
}
