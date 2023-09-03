import { Component, OnInit } from '@angular/core';
import { PostsService } from '../service/data/posts.service';
import { CommentService } from '../service/data/comment.service';
import { JwtAuthenticationService } from '../service/jwt-authentication.service';
import { Router } from '@angular/router';
import { HttpParams } from '@angular/common/http';
export class Posts{
  constructor(
    public post_id: string | null,
    public user_id: string | null,
    public content: string | null,
    public createdAt: Date | null
  ){}
}

export interface PostsResponse{
  content:{
    post_id: string | null,
    user_id: string | null,
    content: string | null,
    createdAt: Date | null
  }[];
}

@Component({
  selector: 'app-postgrid',
  templateUrl: './postgrid.component.html',
  styleUrls: ['./postgrid.component.css']
})
export class PostgridComponent implements OnInit{

  totalPages: number= 0;
  currentPage: number=0;
  posts: Posts[] = [];

  constructor(
    private service : PostsService,
    private router: Router,
    private commentService : CommentService,
    public jwtAuthenticationService: JwtAuthenticationService
  ){}
  ngOnInit(): void {
    if(this.jwtAuthenticationService.isUserLoggedIn() == false)
    {
      this.router.navigate(["/login"])
    }
    console.log(this.currentPage+"\t before");

    let param= new HttpParams().set('size', '4')
                     .set('sort', 'createdAt,desc')
                     .set('page', this.currentPage.toString());
    console.log(param);
    this.service.retriveAllPosts(param).subscribe(
      response =>{
        this.posts = response.content;
        this.totalPages=response.totalPages;
        this.currentPage= response.number;
      }
    )
  }
  postDetails(post_id: string| null)
  {
    this.router.navigate(['posts',post_id])
  }

  prevPage()
  {
    this.currentPage= this.currentPage-1;
    this.ngOnInit();
  }
  nextPage()
  {
    this.currentPage= this.currentPage+1;
    this.ngOnInit();
  }
}
