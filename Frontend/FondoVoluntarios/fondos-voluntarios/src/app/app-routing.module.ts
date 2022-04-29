import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SucursalesComponent } from './components/sucursales/sucursales.component';
import { SuscripcionComponent } from './components/suscripcion/suscripcion.component';

const routes: Routes = [
  {
    path: 'suscripcion',
    component: SuscripcionComponent
    
  }, 
  {
    path: 'sucursal', component: SucursalesComponent
  },
  {
    path: '',
    redirectTo: 'suscripcion',
    pathMatch: 'full',
  },
  { path: '**', redirectTo: 'suscripcion' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
