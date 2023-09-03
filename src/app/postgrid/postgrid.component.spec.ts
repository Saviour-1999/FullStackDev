import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostgridComponent } from './postgrid.component';

describe('PostgridComponent', () => {
  let component: PostgridComponent;
  let fixture: ComponentFixture<PostgridComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostgridComponent]
    });
    fixture = TestBed.createComponent(PostgridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
