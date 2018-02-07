import {Component, OnInit} from '@angular/core';
import {RecipeService} from '../../services/RecipeService';
import {ResponseAPI} from '../../models/ResponseAPI';
import {BsModalRef} from 'ngx-bootstrap';


@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css'],
  providers: [RecipeService]
})
export class RecipeListComponent implements OnInit {

  recipeList: null;
  loading = false;
  modalRef: BsModalRef;

  constructor(private service: RecipeService) {
  }

  ngOnInit() {
    this.loadRecipes();
  }

  loadRecipes() {
    this.loading = true;
    this.service.getAllRecipes()
      .then((data: ResponseAPI) => {
        this.recipeList = data.data;
        this.loading = false;
      })
      .catch(error => this.loading = false);
  }
}
