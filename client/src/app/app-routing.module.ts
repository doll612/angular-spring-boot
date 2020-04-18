import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchPageComponent } from './search-page/search-page.component';
import { PageOneComponent } from './page-one/page-one.component';


const routes: Routes = [
  { path: '', redirectTo: 'search-page', pathMatch: 'full' },
  { path: 'search-page', component: SearchPageComponent },
  { path: 'page-one', component: PageOneComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
