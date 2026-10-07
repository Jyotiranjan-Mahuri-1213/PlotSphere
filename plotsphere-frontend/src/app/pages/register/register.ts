import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from '../../services/auth';
import { User } from '../../models/user';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {

  name: string = '';
  email: string = '';
  password: string = '';
  mobileNo: string = '';

  message: string = '';
  errorMessage: string = '';

  constructor(
    private auth: Auth,
    private router: Router
  ) {}

  register(): void {

    const user = new User(
      0,
      this.name,
      this.email,
      this.mobileNo,
      'CITIZEN'
    );

    const registrationData = {
      name: this.name,
      email: this.email,
      password: this.password,
      mobileNo: this.mobileNo,
      role: 'CITIZEN'
    };

    this.auth.register(registrationData).subscribe({
      next: (response) => {
        console.log('Registration successful:', response);
        this.message = 'Registration successful. Please login.';
        this.errorMessage = '';

        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 1500);
      },

      error: (error) => {
        console.error('Registration failed:', error);
        this.errorMessage = 'Registration failed. Email may already exist.';
        this.message = '';
      }
    });
  }
}