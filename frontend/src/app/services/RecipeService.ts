import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Recipe} from '../models/Recipe';

@Injectable()
export class RecipeService {

  constructor(private http: HttpClient) {}

  getRecipe(id: number) {
    return this.http.get('https://localhost:8443/recipes/' + id).toPromise();
  }

  getAllRecipes() {
    return this.http.get('https://localhost:8443/recipes').toPromise();
  }

  createRecipe(recipe: Recipe) {
    return this.http.post('https://localhost:8443/recipes', recipe).toPromise();
  }
}
