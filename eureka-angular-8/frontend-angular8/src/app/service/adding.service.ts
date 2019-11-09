import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Arithmetic } from '../arithmetic';


@Injectable({
  providedIn: 'root'
})

export class RestService {

  private addingBaseUrl = 'http://localhost:8081/add';
  private subtractBaseUrl = 'http://localhost:8082/subtract';

  constructor(private http: HttpClient) { }

  getAdding() {
    return this.http.get<any>(`${this.addingBaseUrl}`);
  }

  public postAdding(arithmetic: Arithmetic) {
    return this.http.post(`${this.addingBaseUrl}`, arithmetic);
  }


  getSubtraction() {
    return this.http.get<any>(`${this.subtractBaseUrl}`);
  }

  public postSubtract(arithmetic: Arithmetic) {
    return this.http.post(`${this.subtractBaseUrl}`, arithmetic);
  }  
}