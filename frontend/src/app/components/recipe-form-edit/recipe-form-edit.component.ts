import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Component, OnInit, TemplateRef, Input} from '@angular/core';
import {RecipeService} from '../../services/RecipeService';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Recipe} from '../../models/Recipe';
import {Router} from '@angular/router';

@Component({
  selector: 'app-recipe-form-edit',
  templateUrl: './recipe-form-edit.component.html',
  styleUrls: ['./recipe-form-edit.component.css']
})
export class RecipeFormEditComponent implements OnInit {

  recipeForm: FormGroup;
  submitted: false;
  loading = false;
  modalRef: BsModalRef;
  modalMessage = '';
  modalError = false;

  @Input() recipeData: Recipe = null;

  constructor(private formBuilder: FormBuilder, public service: RecipeService, private modalService: BsModalService, private router: Router) {}

  ngOnInit() {

    this.createForm(this.recipeData);
  }

  createForm(recipe: Recipe) {
    this.recipeForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      imagePath: ['', Validators.required],
      ingredients: this.formBuilder.array([])
    });
    this.recipeForm.patchValue({
      name: recipe.name, imagePath: recipe.imagePath, description: recipe.description
    });
    const IngredientsFormGroups = recipe.ingredients.map(ingredient => this.formBuilder.group({
      amount: ingredient.amount, name: ingredient.name
    }));
    const ingredientFormArray = this.formBuilder.array(IngredientsFormGroups);
    this.recipeForm.setControl('ingredients', ingredientFormArray);
  }


  private createIngredient(): FormGroup {
    return this.formBuilder.group({amount: ['', Validators.required], name: ['', Validators.required]});
  }

  get ingredientFormArray(): FormArray {
    return this.recipeForm.get('ingredients') as FormArray;
  }

  addIngredient() {
    this.ingredientFormArray.push(this.createIngredient());
  }

  removeIngredient(index: number) {
    this.ingredientFormArray.removeAt(index);
  }

  resetForm() {
    this.recipeForm.reset();
  }

  onSubmit(template) {
    this.loading = true;
    const recipe = this.recipeForm.value;
    recipe.id = this.recipeData.id;
    this.service.updateRecipe(recipe)
      .then(() => {
        this.loading = false;
        this.modalMessage = 'Recipe Updated';
        this.modalError = false;
        this.router.navigate(['recipes/' + recipe.id]);
        this.openModal(template);

      })
      .catch(error => {
        this.loading = false;
        this.modalMessage = 'Error Updating recipe';
        this.modalError = true;
        this.openModal(template);
      });
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

}
