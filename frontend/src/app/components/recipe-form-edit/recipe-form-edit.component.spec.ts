import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeFormEditComponent } from './recipe-form-edit.component';

describe('RecipeFormEditComponent', () => {
  let component: RecipeFormEditComponent;
  let fixture: ComponentFixture<RecipeFormEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipeFormEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipeFormEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
