import { Component, OnInit } from '@angular/core';
import {Todo} from './todo'
import { TableService } from '../table.service';

@Component({
  selector: 'app-table-comp',
  templateUrl: './table-comp.component.html',
  styleUrls: ['./table-comp.component.css']
})
export class TableCompComponent implements OnInit {

  constructor(private tableService:TableService) { }


  ngOnInit(): void {
    this.getTables();
  }
  todos:Todo[] = []

  hero = 'TestLOL';

  getTables() : void {
    this.tableService.getTodos().subscribe(todos => this.todos = todos);
  }

  deleteTodo(id:number) :void {
    this.tableService.deleteTodo(id);
    this.getTables();
  }

  postTodo(description:string, summary:string) : void {
    this.tableService.postTodo(description, summary);
    this.getTables();
  }
}
