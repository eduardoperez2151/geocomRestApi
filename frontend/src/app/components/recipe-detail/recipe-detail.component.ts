import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {RecipeService} from '../../services/RecipeService';
import {Recipe} from '../../models/Recipe';
import {ResponseAPI} from '../../models/ResponseAPI';


@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css'],
  providers: [RecipeService]
})
export class RecipeDetailComponent implements OnInit {
  recipe: Recipe;
  id: number;
  loading = true;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params
      .subscribe((params: Params) => this.recipeService
        .getRecipe(params['id'])
        .then((data: ResponseAPI) => {
          this.recipe = data.data;
          this.loading = false;
        }));
  }


  onEditRecipe() {
    // completar
  }

  onDeleteRecipe() {
    //  this.recipeService.deleteRecipe(this.id);
    //  this.router.navigate(['/recipes']);
  }

}
