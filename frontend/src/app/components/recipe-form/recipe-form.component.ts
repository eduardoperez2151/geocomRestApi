import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Component, OnInit, TemplateRef} from '@angular/core';
import {RecipeService} from '../../services/RecipeService';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.css']
})
export class RecipeFormComponent implements OnInit {

  recipeForm: FormGroup;
  submitted: false;
  loading = false;
  modalRef: BsModalRef;
  modalMessage = '';
  modalError = false;
  recipeData = null;

  constructor(private formBuilder: FormBuilder, public service: RecipeService, private modalService: BsModalService) {
  }

  ngOnInit() {
    this.recipeData = this.service.recipe;
    if (this.recipeData) {
      alert();
      this.editForm(this.recipeData);
    } else {
      this.createForm();
    }
  }

  createForm() {
    this.recipeForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      imagePath: ['', Validators.required],
      ingredients: this.formBuilder.array([this.createIngredient()])
    });
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
    this.service.createRecipe(recipe)
      .then(() => {
        this.loading = false;
        this.modalMessage = 'New Recipe created';
        this.modalError = false;
        this.openModal(template);
        this.resetForm();

      })
      .catch(error => {
        this.loading = false;
        this.modalMessage = 'Recipe not created';
        this.modalError = true;
        this.openModal(template);
      });
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  editForm(recipeData) {
    alert(recipeData);
  }
}
