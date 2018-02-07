import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class IngredientService {

  constructor(private http: HttpClient) {}

  getAllIngredients() {
    return this.http.get('https://localhost:8443/ingredients');
  }
}
