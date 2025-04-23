import { Component, ViewChild, viewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BackgroundImgComponent } from './components/background-img/background-img.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';


@Component({
  selector: 'app-root',
  imports: [
    RouterModule,
    HeaderComponent,
    FooterComponent,
    BackgroundImgComponent,
    SidebarComponent
  ],
  templateUrl: './app.component.html',
  // template: '<router-outlet></router-outlet>',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'dungeon-fighter';

  @ViewChild(SidebarComponent) sidebar!: SidebarComponent;

  toggleSidebar() {
    console.log("toggle called")
    this.sidebar.toggle();
  }
}
