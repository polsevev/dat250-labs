import { HttpClient, HttpHeaders } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { TableCompComponent } from './table-comp/table-comp.component';
import {Todo} from './table-comp/todo'
import { Injectable } from '@angular/core';
import { TestBed } from '@angular/core/testing';

@Injectable({
  providedIn: 'root',
})


export class TableService {
    constructor( private http: HttpClient ) { 

        }

    private todoUrl = '/todos';  // URL to web api
    httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };
      
    /** GET heroes from the server */
    getTodos(): Observable<Todo[]> {
        //return this.http.get<Todo[]>(this.todoUrl)
        let res = this.http.get<Todo[]>(this.todoUrl)
        return res;
    }

    deleteTodo(todoID:number):void {
        let url = this.todoUrl + "/" + todoID;
        console.log(url);
        this.http.delete(url).subscribe();
    }

    postTodo(description:string, summary:string):void{
        console.log(description + ", " + summary);
        let todo = {"description":description, "summary":summary};
        this.http.post(this.todoUrl, todo, this.httpOptions).subscribe();
        this.getTodos();
    }

}


