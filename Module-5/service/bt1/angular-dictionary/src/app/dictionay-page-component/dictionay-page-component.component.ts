import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";
import {IWord} from "../model/iword";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {

  words: IWord[] = [];

    constructor(private wordService: DictionaryService,   private router: Router) { }

  getAll(){
    this.words = this.wordService.getAll();
  }

  ngOnInit(){
      this.getAll();
  }

  detail(word:string | undefined){
      this.router.navigate(["/detail", word]);
  }
}
