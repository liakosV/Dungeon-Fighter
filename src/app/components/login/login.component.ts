import { Component } from '@angular/core';
import { ISourceOptions } from '@tsparticles/engine'
import { BackgroundImgComponent } from '../background-img/background-img.component';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  imports: [BackgroundImgComponent, RouterModule],

})
export class LoginComponent {

  // tsparticles = '';
  // particlesOptions: ISourceOptions = {
  //   fullScreen: { enable: false },
  //   particles: {
  //     number: {
  //       value: 20,
  //       density: { enable: true }
  //       // density: { enable: true, area: 800 }
  //     },
  //     color: {
  //       value: ['#ffaa00', '#ff5500', '#ff2200'] // ember colors
  //     },
  //     shape: { type: 'circle' },
  //     opacity: {
  //       value: 0.8,
  //       animation: {
  //         enable: true,
  //         speed: 0.5,
  //         // minimumValue: 0.3,
  //         sync: false
  //       }
  //     },
  //     size: {
  //       value: 4,
  //       // random: true,
  //       animation: {
  //         enable: true,
  //         speed: 4,
  //         // minimumValue: 1,
  //         sync: false
  //       }
  //     },
  //     move: {
  //       enable: true,
  //       speed: 1,
  //       direction: 'top',
  //       random: true,
  //       outModes: { default: 'out' }
  //     }
  //   },
  //   detectRetina: true,
  //   background: { color: 'transparent' }
  // };
}
