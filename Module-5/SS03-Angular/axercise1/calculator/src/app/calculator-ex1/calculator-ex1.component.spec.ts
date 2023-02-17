import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatorEx1Component } from './calculator-ex1.component';

describe('CalculatorEx1Component', () => {
  let component: CalculatorEx1Component;
  let fixture: ComponentFixture<CalculatorEx1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalculatorEx1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatorEx1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
