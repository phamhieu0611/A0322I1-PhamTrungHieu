import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {

  pickColor = {textTy: 'This text color can change!', theColor: 'black'};

  pickerColor(textTy: string){
    this.pickColor.textTy = textTy;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
