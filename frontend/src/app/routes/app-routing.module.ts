import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
// import {RecipeDetailComponent} from '../components/recipe-detail/recipe-detail.component';
// import {RecipeComponent} from '../components/recipe/recipe.component';
import {IngredientListComponent} from '../components/ingredient-list/ingredient-list.component';
// import {RecipeFormComponent} from "../components/recipe-form/recipe-form.component";

export const navigationRoutes: Routes = [
  // { path: '', redirectTo: '/recipes', pathMatch: 'full' },
  // { path: 'recipes', component: RecipeComponent},
  // { path: 'recipes/new', component: RecipeFormComponent },
  // { path: 'recipes/:id', component: RecipeDetailComponent },
  { path: 'ingredients', component: IngredientListComponent},
];

@NgModule({
  exports: [ RouterModule]
})

export class AppRoutingModule { }
