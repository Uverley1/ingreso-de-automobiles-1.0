package controller;

import view.VehiculoView;

import dao.VehiculoDAO;

public class VehiculoController {
    
    private VehiculoView view;
    private VehiculoDAO vehiculoDAO;

    public VehiculoController(VehiculoView view){
        this.view = view;
        this.vehiculoDAO = new VehiculoDAO();
    }

    public int iniciar(){
        int option;
        do{
            option = view.MostrarMenuLeerOpcion();
            switch (option) {
                case 1:
                    vehiculoDAO.guardarVehiculo(view.leerDatosVehiculo());
                    break;
                case 2:
                    view.mostrarVehiculos(vehiculoDAO);
                    break;
                case 3:
                    vehiculoDAO.eliminarVehiculo(view.leerPlaca().getPlaca());
                    break;
                case 0:
                    view.salir();
                    break;
                
                    default:
                        System.out.println("Opcion Invalida");

            }
        }
        while (option !=0);
        return option;
            
    }

}
