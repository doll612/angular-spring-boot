import { Component } from '@angular/core';
import { myAnimation } from './route.animation';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  animations: [myAnimation]
})
export class AppComponent {
  title = 'client';
}
