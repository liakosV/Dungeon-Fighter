import { Component, signal } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormControl, FormGroup, Validators, ReactiveFormsModule, AbstractControl, ValidationErrors } from '@angular/forms';

import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-sign-up',
  imports: [
    RouterModule, 
    ReactiveFormsModule, 
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule
  ],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {
  form = new FormGroup( {
    username: new FormControl('', [Validators.required, Validators.maxLength(32)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required),
    confirmPassword: new FormControl('', [Validators.required, this.passwordConfirmValidator]),

  })

  hide = signal(true);
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation
  }

  passwordConfirmValidator(control: AbstractControl): ValidationErrors | null {
    const password = control.parent?.get('password');
    const confirmPassword = control.parent?.get('confirmPassword');
    return password?.value == confirmPassword?.value ? null : { 'notSame': true}
  }

  onSubmit() {
    const isPasswordConfirmed = this.form.get('password')?.value == this.form.get('confirmPassword')?.value;

    if(this.form.valid && isPasswordConfirmed) {
      console.log(this.form.value)
    }
  }

  onSetValue() {
    this.form.setValue({
      username: "john",
      email: "john@example.com",
      password: "12345",
      confirmPassword: "12345",
    })
  }
}
