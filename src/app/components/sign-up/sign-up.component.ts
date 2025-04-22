import { Component } from '@angular/core';
import { BackgroundImgComponent } from '../background-img/background-img.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  imports: [BackgroundImgComponent, RouterModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {

}
