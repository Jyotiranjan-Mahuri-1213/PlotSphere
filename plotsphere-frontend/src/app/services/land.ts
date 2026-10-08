import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Land } from '../models/land';

@Injectable({
  providedIn: 'root'
})
export class LandService {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8082/api/lands';

  getAllLands(): Observable<Land[]> {
    return this.http.get<Land[]>(this.apiUrl);
  }

  getLandById(id: number): Observable<Land> {
    return this.http.get<Land>(`${this.apiUrl}/${id}`);
  }

  getLandsByOwner(ownerId: number): Observable<Land[]> {
    return this.http.get<Land[]>(`${this.apiUrl}/owner/${ownerId}`);
  }
}