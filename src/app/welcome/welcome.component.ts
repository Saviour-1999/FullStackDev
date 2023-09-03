import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeService } from '../service/data/welcome.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit{

  constructor(private route : ActivatedRoute,
    private service : WelcomeService
  ){}

  ngOnInit(): void {
    console.log("WelcomeComponent ngOnInit");
  }

  getWelcomeMessage()
  {
    console.log("get welcome");
    this.service.executeWelcomeMessageService().subscribe();
  }

}
