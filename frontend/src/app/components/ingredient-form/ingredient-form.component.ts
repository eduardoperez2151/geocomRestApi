import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-ingredient-form',
  templateUrl: './ingredient-form.component.html',
  styleUrls: ['./ingredient-form.component.css']
})
export class IngredientFormComponent implements OnInit {

  @Input()
  public ingredientForm: FormGroup;

  constructor() {
  }

  ngOnInit() {
  }

}
