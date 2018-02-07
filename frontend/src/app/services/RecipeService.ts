import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Recipe} from '../models/Recipe';
import {RECIPE_SERVICES_URL} from './ServiceUrls';

@Injectable()
export class RecipeService {

  public recipe: Recipe;

  constructor(private http: HttpClient) {
  }

  getRecipe(id: number) {
    return this.http.get(RECIPE_SERVICES_URL + id).toPromise();
  }

  getAllRecipes() {
    return this.http.get(RECIPE_SERVICES_URL).toPromise();
  }

  createRecipe(recipe: Recipe) {
    return this.http.post(RECIPE_SERVICES_URL, recipe).toPromise();
  }

  updateRecipe(recipe: Recipe) {
    return this.http.patch(RECIPE_SERVICES_URL, recipe).toPromise();
  }
}
