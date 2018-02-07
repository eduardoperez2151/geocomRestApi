import {Component, OnInit} from '@angular/core';
import {IngredientService} from '../../services/IngredientService';
import {ResponseAPI} from '../../models/ResponseAPI';

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css'],
  providers: [IngredientService]
})
export class IngredientListComponent implements OnInit {

  ingredientList = [];
  constructor(private service: IngredientService) {
  }

  ngOnInit() {
    this.service.getAllIngredients()
      .subscribe((data: ResponseAPI) => {
        this.ingredientList = data.data;
      });
  }

}
