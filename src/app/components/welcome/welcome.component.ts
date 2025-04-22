import { Component } from '@angular/core';
import { BackgroundImgComponent } from '../background-img/background-img.component';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-welcome',
  imports: [
    BackgroundImgComponent,
    RouterModule
  ],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent {
  constructor(private router: Router) {}

  goToLogin() {
    this.router.navigate(['/login'])
  }
}
