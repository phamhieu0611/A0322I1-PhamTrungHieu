import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DictionaryService} from "../service/dictionary.service";
import {IWord} from "../model/iword";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-dictionary-detail-component',
  templateUrl: './dictionary-detail-component.component.html',
  styleUrls: ['./dictionary-detail-component.component.css']
})
export class DictionaryDetailComponentComponent implements OnInit {

  word: IWord;

  constructor(private activatedRoute: ActivatedRoute,
              private wordService: DictionaryService,
              private domSanitizer: DomSanitizer) {  }


  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) =>{
      const word = paramMap.get('word');
      this.word = this.wordService.findByWord(word)
      console.log(this.word);
    })
  }

}
