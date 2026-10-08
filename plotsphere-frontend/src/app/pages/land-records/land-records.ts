import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { LandService } from '../../services/land';
import { Land } from '../../models/land';

@Component({
  selector: 'app-land-records',
  imports: [],
  templateUrl: './land-records.html',
  styleUrl: './land-records.css'
})
export class LandRecords implements OnInit {

  lands: Land[] = [];
  errorMessage: string = '';

  constructor(
    private landService: LandService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadLands();
  }

  loadLands(): void {

    this.landService.getLandsByOwner(1).subscribe({

      next: (data) => {
        this.lands = data;

        console.log('Land records:', data);

        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error('Failed to load land records:', error);
        this.errorMessage = 'Unable to load land records.';
        this.cdr.detectChanges();
      }

    });
  }
}