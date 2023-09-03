import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { PostgridComponent } from './postgrid/postgrid.component';
import { LogoutComponent } from './logout/logout.component';
import { PostdetailsComponent } from './postdetails/postdetails.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UserCreateComponent } from './user-create/user-create.component';

const routes: Routes = [
  {path: '', component : LoginComponent},
  {path: 'login', component : LoginComponent},
  {path: 'logout', component : LogoutComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path:'posts', component: PostgridComponent},
  {path:'create', component: CreatePostComponent},
  {path:'signup', component: UserCreateComponent},
  {path:'posts/:id', component: PostdetailsComponent},
  {path : '**', component : ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
