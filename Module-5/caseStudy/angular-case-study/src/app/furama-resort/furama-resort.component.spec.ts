import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuramaResortComponent } from './furama-resort.component';

describe('FuramaResortComponent', () => {
  let component: FuramaResortComponent;
  let fixture: ComponentFixture<FuramaResortComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuramaResortComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuramaResortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
