import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableCompComponent } from './table-comp.component';

describe('TableCompComponent', () => {
  let component: TableCompComponent;
  let fixture: ComponentFixture<TableCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableCompComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
