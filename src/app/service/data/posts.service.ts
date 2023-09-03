import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { API_URL } from 'src/app/app.constants';
import { Posts, PostsResponse } from 'src/app/postgrid/postgrid.component';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) { }

  retriveAllPosts(params: HttpParams){
    return this.http.get<any>(`${API_URL}/post/viewPost`,{params});
  }

  retrivePostById(post_id : string){
    return this.http.get<Posts>(`${API_URL}/post/${post_id}`);
  }

  createPostService(post: Posts)
  {
    return this.http.post(`${API_URL}/post/create`,post,{responseType: 'text'});
  }
}
