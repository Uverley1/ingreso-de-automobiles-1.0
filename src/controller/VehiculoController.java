package controller;

import view.VehiculoView;

import java.util.ArrayList;

import java.util.List;

import model.Vehiculo;

public class VehiculoController {
    
    private VehiculoView view;
    private List<Vehiculo> vehiculos;
    
    public VehiculoController(VehiculoView view){
        this.view = view;
        this.vehiculos = new ArrayList<>();
    }

    public void iniciar(){
        int opcion;
        do{
            opcion = view.MostrarMenuLeerOpcion();
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    view.mostrarVehiculos(vehiculos);
                    break;
                case 3:
                    EliminarVehiculo();
                    break;
                case 4:
                    System.out.println("0. Salir");
                    break;
                
                    default:
                        System.out.println("Opcion Invalida");

            }
        }while (opcion !=0);
            
    }
    private void agregarVehiculo(){
        Vehiculo v = view.leerDatosVehiculo();
        vehiculos.add(v);
        view.AgregarVehiculo(v);
    }
    private void EliminarVehiculo(){
        String placa = view.LeerPlacaEliminar();
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                vehiculos.remove(v);
                System.out.println("Vehiculo con placa " + placa + " eliminado.");
                return;
            }
        }
        System.out.println("Vehiculo con placa " + placa + " no encontrado.");
    }

}
