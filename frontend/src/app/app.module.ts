import {NgModule} from '@angular/core';
import {LoadingModule} from 'ngx-loading';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule, navigationRoutes} from './routes/app-routing.module';
import {RecipeFormComponent} from './components/recipe-form/recipe-form.component';
import { RecipeListComponent } from './components/recipe-list/recipe-list.component';
import { RecipeItemComponent } from './components/recipe-item/recipe-item.component';
import { RecipeDetailComponent } from './components/recipe-detail/recipe-detail.component';
import {NavigationBarComponent} from './components/navigation-bar/navigation-bar.component';
import {IngredientListComponent} from './components/ingredient-list/ingredient-list.component';
import {IngredientFormComponent} from './components/ingredient-form/ingredient-form.component';
import {ModalModule} from 'ngx-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    IngredientListComponent,
    RecipeListComponent,
    RecipeItemComponent,
    RecipeDetailComponent,
    IngredientFormComponent,
    RecipeFormComponent
  ],
  imports: [
    LoadingModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ModalModule.forRoot(),
    RouterModule.forRoot(navigationRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
