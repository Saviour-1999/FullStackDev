import { Component, OnInit } from '@angular/core';
import { Posts } from '../postgrid/postgrid.component';
import { ActivatedRoute, Router } from '@angular/router';
import { PostsService } from '../service/data/posts.service';
import { CommentService } from '../service/data/comment.service';
import { JwtAuthenticationService } from '../service/jwt-authentication.service';
import { HttpParams } from '@angular/common/http';

export class Comments{
  constructor(
    public comment_value: string | null,
    public user_id: string | null,
    public post_id: string |null,
    public createdAt: Date | null
  ){}
}

@Component({
  selector: 'app-postdetails',
  templateUrl: './postdetails.component.html',
  styleUrls: ['./postdetails.component.css']
})
export class PostdetailsComponent implements OnInit {
 
  id : string ='1';
  post: Posts = new Posts(this.id,null,null,null);
  comments: Comments[] =[];
  comment: Comments = new Comments(null,null,null,null);
  totalPages: number= 1;
  currentPage: number=0;

  constructor(private route : ActivatedRoute,
    private router: Router,
    private postsService : PostsService,
    private jwtAuthenticationService : JwtAuthenticationService,
    private commentService : CommentService){

  }

  ngOnInit(){
    this.id = this.route.snapshot.params['id'];
    this.post = new Posts(this.id,null,null,null);
    let param= new HttpParams().set('size', '4')
                     .set('sort', 'createdAt,desc')
                     .set('page', this.currentPage.toString());
    this.commentService.showAllCommentsByPost_Id(param,this.id).subscribe(
      response=> {this.comments= response.content;
        this.totalPages=response.totalPages;
        if(this.totalPages==0)
        {
          this.totalPages=1;
        }
        this.currentPage= response.number;}
    )
    this.postsService.retrivePostById(this.id).subscribe(
        data=> this.post = data
    )
   
  }

  addComment()
  {
    this.comment.user_id = this.jwtAuthenticationService.getAuthenticatedUser();
    this.comment.post_id = this.id;
    this.commentService.addCommentService(this.comment).subscribe(
    ()=>{
      this.comment.comment_value = '';
      this.ngOnInit();
      this.router.navigate(['posts',this.id]);
    }
    );
  }
  prevPageComments()
  {
    this.currentPage= this.currentPage-1;
    this.ngOnInit();
  }
  nextPageComments()
  {
    this.currentPage= this.currentPage+1;
    this.ngOnInit();
  }
  }

