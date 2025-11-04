import { Component, signal } from '@angular/core';
import { ISourceOptions } from '@tsparticles/engine'
import { Router, RouterLink, RouterModule } from '@angular/router';
import { AuthService } from '../../auth.service';
import { FormGroup, FormsModule, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { UserLogin } from '../../shared/interfaces/user-login';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  imports: [
    RouterModule, 
    FormsModule, 
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule,
    ReactiveFormsModule
  ],
})
export class LoginComponent {
  form = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })

  // username: string = '';
  // password: string = '';
  loginFailed: boolean = false;

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    const user: UserLogin = {
      username: this.form.value.username ?? '',
      password: this.form.value.password ?? ''
    };
    

    const isLoginSuccefull = this.authService.login(user);
    if(isLoginSuccefull) {
      this.loginFailed = false;
      this.router.navigate(['/dashboard'])
      console.log("Successful Login")
      
    } else {
      console.log("Login Failed")
      this.loginFailed = true;

      setTimeout(() => {
        this.loginFailed = false;
      }, 3000)
    }
    
  }

  hide = signal(true);
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }
  
}
