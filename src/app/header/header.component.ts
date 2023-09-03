import { Component } from '@angular/core';
import { JwtAuthenticationService } from '../service/jwt-authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(public jwtAuthenticationService: JwtAuthenticationService)
  {

  }

}
