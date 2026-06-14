import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

import { Trip } from '../models/trip';

@Injectable({
  providedIn: 'root',
})

export class TripData {

  constructor(private http:HttpClient) {}
   url = 'http://localhost:3000/api/trips'
  getTrips(): Observable<Trip[]> {


    //let url = '/api/trips';

    //console.log(this.http.get<Trip[]>(url));

    return this.http.get<Trip[]>(this.url);

    /*
    return this.http.get(url, { responseType: 'text' }).pipe(
      map(response => {
        console.log(response);
        // Remove any invisible BOM characters or whitespace
        const cleanJson = response.replace(/^\uFEFF/, '').trim();
        //return JSON.parse(cleanJson) as Trip[];
        return response as Trip;
      })
    );*/
  }

  addTrip(formData:Trip) : Observable<Trip[]>{

    return this.http.post<Trip[]>(this.url,formData);

  }

  getTrip(tripCode:String) : Observable<Trip[]>{

    return this.http.get<Trip[]>(this.url + '/' + tripCode);

  }

  updateTrip(formData:Trip): Observable<Trip>{
    //console.log('Inside TripData::addTrips');
    return this.http.put<Trip>(this.url + '/' + formData.code, formData);
  }



}
