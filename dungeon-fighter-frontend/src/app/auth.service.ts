import { Injectable } from '@angular/core';
import { UserLogin } from './shared/interfaces/user-login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // private tokenKey = 'auth_token';
  private loggedIn = false;

  constructor() { }

  login(user: UserLogin) {
    if (user.username == 'admin' && user.password == '12345') {
      // localStorage.setItem(this.tokenKey, 'mock-jwt-token');
      this.loggedIn = true;
      return true;
    }
    return false;
  }

  logout(): void {
    // localStorage.removeItem(this.tokenKey);
    this.loggedIn = false
  }

  isAuthenticated(): boolean {
    // return !!localStorage.getItem(this.tokenKey);
    return this.loggedIn;
  }
}
