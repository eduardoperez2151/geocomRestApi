import {Ingredient} from './Ingredient';

export class Recipe {

  public id: number;
  public name: string;
  public description: string;
  public imagePath: string;
  public ingredients: Ingredient[];

  constructor() {
    this.ingredients = [];
  }
}
