import { JwtAuthenticationService } from '../service/jwt-authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private jwtAuthenticationService: JwtAuthenticationService
  ) { }

  ngOnInit() {
    this.jwtAuthenticationService.logout();
  }

}
