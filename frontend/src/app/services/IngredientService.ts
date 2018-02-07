import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {INGREDIENT_SERVICES_URL} from './ServiceUrls';

@Injectable()
export class IngredientService {

  constructor(private http: HttpClient) {}

  getAllIngredients() {
    return this.http.get(INGREDIENT_SERVICES_URL);
  }
}
