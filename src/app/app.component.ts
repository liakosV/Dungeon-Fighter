import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BackgroundImgComponent } from './components/background-img/background-img.component';


@Component({
  selector: 'app-root',
  imports: [RouterModule],
  // templateUrl: './app.component.html',
  template: '<router-outlet></router-outlet>',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'dungeon-fighter';
}
