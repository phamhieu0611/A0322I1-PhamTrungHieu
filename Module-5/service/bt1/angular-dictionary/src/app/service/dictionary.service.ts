import { Injectable } from '@angular/core';
import {IWord} from "../model/iword";
import {element} from "protractor";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  words: IWord[] = [
    {
   word: 'hello',
   mean: 'Xin chào'
  }, {
      word: 'apple',
      mean: 'Quả táo'
    }, {
      word: 'black',
      mean: 'Màu đen'
    }, {
      word: 'green',
      mean: 'Màu xanh lá'
    }, {
      word: 'red',
      mean: 'Màu đỏ'
    }, {
      word: 'pillow',
      mean: 'Cái gối'
    }, {
      word: 'blanket',
      mean: 'Cái chăn'
    }];

  constructor() { }

  getAll(){
    return this.words;
  }

  findByWord(word: string) : IWord {
    return this.words.filter(element => element.word === word)[0];
  }
}
