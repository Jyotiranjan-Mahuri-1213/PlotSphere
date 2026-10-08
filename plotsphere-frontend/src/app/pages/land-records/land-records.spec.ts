import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LandRecords } from './land-records';

describe('LandRecords', () => {
  let component: LandRecords;
  let fixture: ComponentFixture<LandRecords>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LandRecords],
    }).compileComponents();

    fixture = TestBed.createComponent(LandRecords);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
