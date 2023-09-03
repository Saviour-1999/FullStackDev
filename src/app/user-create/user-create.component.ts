import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../service/data/user-service.service';


export class User{
  constructor(
    public user_id: string | null,
    public password: string | null,
    public mail_id: string | null
  ){}
}

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})

export class UserCreateComponent {

  user : User = new User(null,null,null);

  constructor(private router: Router,
    private userServiceService: UserServiceService){}

addUser()
{
   this.userServiceService.addUserService(this.user).subscribe(
    response =>{
      this.router.navigate(['login']);
    }
   );
}

}
