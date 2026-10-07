import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { LoginRequest } from '../models/login-request';

@Injectable({
  providedIn: 'root'
})
export class Auth {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8081/api/auth';

  login(loginRequest: LoginRequest): Observable<any> {
    return this.http.post<any>(
      `${this.apiUrl}/login`,
      loginRequest
    );
  }

  register(user: any): Observable<any> {
    return this.http.post<any>(
      `${this.apiUrl}/register`,
      user
    );
  }

  saveToken(token: string): void {
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }
}