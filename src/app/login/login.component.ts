import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { WelcomeComponent } from '../welcome/welcome.component';
import { JwtAuthenticationService } from '../service/jwt-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  username = 'akash'
  password = 'hsaka'
  errorMessage = 'Invalid Credentials'
  invalidLogin = false
  
  constructor(private router : Router,
    private jwtAuthenticationService: JwtAuthenticationService){
  }

  handleLogin():void
  {
    // if(this.username == 'akash' && this.password == 'lol')
    // {
    //   this.router.navigate(['posts']);
    // }
    // else
    // {
    //   this.router.navigate(['error']);
    // }
    // console.log(this.username)
    
      this.jwtAuthenticationService.executeJWTAuthenticationService(this.username, this.password);
    }
  }
