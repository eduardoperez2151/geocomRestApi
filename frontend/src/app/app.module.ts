import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule, navigationRoutes} from './routes/app-routing.module';
import {IngredientListComponent} from './components/ingredient-list/ingredient-list.component';
import {NavigationBarComponent} from './components/navigation-bar/navigation-bar.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    IngredientListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    RouterModule.forRoot(navigationRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
