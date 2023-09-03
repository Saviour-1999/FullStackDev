import { Component } from '@angular/core';
import { Posts } from '../postgrid/postgrid.component';
import { PostsService } from '../service/data/posts.service';
import { Router } from '@angular/router';
import { JwtAuthenticationService } from '../service/jwt-authentication.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent {

  constructor(private postsService: PostsService,
    private router:Router,
    private jwtAuthenticationService: JwtAuthenticationService)
  {
  }

  post:Posts = new Posts(null,null,null,null);

  savePost()
  {
    this.post.user_id = this.jwtAuthenticationService.getAuthenticatedUser();
    this.postsService.createPostService(this.post).subscribe(
      ()=>{
        this.router.navigate(['posts']);
      }
    );
  }

}
