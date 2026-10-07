import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { Auth } from '../../services/auth';
import { LoginRequest } from '../../models/login-request';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(
    private auth: Auth,
    private router: Router
  ) {}

  login(): void {

    const loginRequest = new LoginRequest(
      this.email,
      this.password
    );

    this.auth.login(loginRequest).subscribe({

      next: (response) => {
        console.log('Login successful:', response);

        this.auth.saveToken(response.token);

        this.router.navigate(['/dashboard']);
      },

      error: (error) => {
        console.error('Login failed:', error);

        this.errorMessage = 'Invalid email or password';
      }

    });
  }
}