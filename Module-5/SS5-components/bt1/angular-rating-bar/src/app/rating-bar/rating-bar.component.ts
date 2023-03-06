import { Component, EventEmitter, Input, Output, OnChanges, SimpleChanges, OnInit } from '@angular/core';
import {IRatingUnit} from "../irating-unit";

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit, OnChanges {

  @Input()
  max = 10;
  @Input()
  ratingValue = 8;
  @Input()
  showRatingValue = true;

  @Output()
  rateChange = new EventEmitter<number>();

  ratingUnits: Array<IRatingUnit> = [];

  constructor() { }

  calculate(max, ratingValue){
    this.ratingUnits = Array.from({length: max},
      (_, index) =>({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  ngOnChanges(changes: SimpleChanges){
    if ('max' in changes){
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 5 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }

  ngOnInit() {
    this.calculate(this.max, this.ratingValue);
  }

  select(index){
    this.ratingValue = index+1;
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
    this.rateChange.emit(this.ratingValue);
  }enter(index){
    this.ratingUnits.forEach((item, idx) =>item.active = idx <= index);
  }reset() {
    this.ratingUnits.forEach((item, idx) => idx < this.ratingValue);
}

}
