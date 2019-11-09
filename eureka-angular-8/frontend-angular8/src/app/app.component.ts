import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";
import { RestService } from './service/adding.service';
import { Arithmetic } from './arithmetic';

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html'
})

export class AppComponent implements OnInit {
    addingForm: FormGroup;
    addingRes: any = { 'nr1': '', 'nr2': '', 'sum': '' };
    addingResultStr: string;

    subtractForm: FormGroup;
    subtractRes: any = { 'nr1': '', 'nr2': '', 'subtr': '' };
    subtractResultStr: string;

    constructor(private addingService: RestService,
        private subtractService: RestService) { }

    ngOnInit() {
        this.addingForm = new FormGroup({
            nr1: new FormControl(""),
            nr2: new FormControl("")
        });

        this.subtractForm = new FormGroup({
            nr1: new FormControl(""),
            nr2: new FormControl("")
        });
    }

    getAdding() {
        this.addingService.getAdding().subscribe(res => {
            this.addingRes = res;
            this.addingResultStr = this.addingRes.int1 + " + " + this.addingRes.int2 + " = " + this.addingRes.sum;
        });
    }

    onAddingSubmit(form) {
        let arith: Arithmetic = { "nr1": form.controls.nr1.value, "nr2": form.controls.nr2.value }

        this.addingService.postAdding(arith)
            .subscribe(
                data => {
                    this.delay(100);
                    this.getAdding();
                },
                error => {
                    alert("Error");
                }
            );
    }

    getSubtraction() {
        this.subtractService.getSubtraction().subscribe(res => {
            this.subtractRes = res;
            this.subtractResultStr = this.subtractRes.int1 + " - " + this.subtractRes.int2 + " = " + this.subtractRes.subtr;
        });
    }

    onSubtractSubmit(form) {
        let arith: Arithmetic = { "nr1": form.controls.nr1.value, "nr2": form.controls.nr2.value }

        this.subtractService.postSubtract(arith)
            .subscribe(
                data => {
                    this.delay(100);
                    this.getSubtraction();
                },
                error => {
                    alert("Post error");
                }
            );
    }

    delay(ms) {
        var startTime = new Date().getTime();
        var diff = 0;
        while (diff < ms) {
            var currentTime = Date.now();
            diff = currentTime - startTime;
        }
    }
}