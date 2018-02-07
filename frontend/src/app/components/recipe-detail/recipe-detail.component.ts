import {Component, OnInit, TemplateRef} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {RecipeService} from '../../services/RecipeService';
import {Recipe} from '../../models/Recipe';
import {ResponseAPI} from '../../models/ResponseAPI';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';


@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css'],

})
export class RecipeDetailComponent implements OnInit {
  recipe: Recipe;
  id: number;
  loading = true;
  modalRef: BsModalRef;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute, private modalService: BsModalService) {
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

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  onDeleteRecipe() {
    //  this.recipeService.deleteRecipe(this.id);
    //  this.router.navigate(['/recipes']);
  }

}
