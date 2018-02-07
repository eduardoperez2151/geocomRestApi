import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from '../../models/Recipe';
import {Router} from '@angular/router';
import {RecipeService} from '../../services/RecipeService';


@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css'],
})
export class RecipeItemComponent implements OnInit {
  @Input() recipe: Recipe;
  @Input() index: number;

  constructor( private router: Router, public service: RecipeService) {}

  ngOnInit() {
  }
}
