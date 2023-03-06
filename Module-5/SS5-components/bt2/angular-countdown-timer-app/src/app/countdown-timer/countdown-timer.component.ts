import { Component, EventEmitter, Input, Output, OnChanges, SimpleChanges, OnInit , OnDestroy} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit , OnChanges, OnDestroy{
  message = '';
  remainningTime: number;
  @Input()
  secconds = 10;
  @Output()
  finish = new EventEmitter<boolean>();
  private intervalId = 0;

  ngOnChanges(changes: SimpleChanges): void {
    if ('seconds' in changes) {
      let v = changes.seconds.currentValue;
      v = typeof v  === 'undefined' ? 10 : v;
      const vFixed = Number(v);
      this.secconds = Number.isNaN(vFixed) ? 10 : vFixed;
    }
  }

  start(){
    this.countDown();
    if (this.remainningTime <= 0){
      this.remainningTime = this.secconds;
    }
  }

  clearTime(){
    clearInterval(this.intervalId);
  }

  reset(){
    this.clearTime();
    this.remainningTime = this.secconds;
    this.message = 'click start button to cd'
  }

  stop(){
    this.clearTime();
    this.message = `holding at T-${this.remainningTime} seconds`
  }

  private countDown() {
    this.clearTime();
    this.intervalId = window.setInterval(() => {
      this.remainningTime -= 1;
      if (this.remainningTime === 0) {
        this.message = 'Blast off!';
        this.clearTime();
        this.finish.emit(true);
      } else {
        this.message = `T-${this.remainningTime} seconds and counting`;
      }
    }, 1000);
  }

  constructor() { }

  ngOnInit(): void {
    this.reset();
  }

  ngOnDestroy(): void {
  }

}
