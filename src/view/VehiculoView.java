package view;
import java.util.Scanner;
import model.Vehiculo;

import dao.VehiculoDAO;

public class VehiculoView  {
    private Scanner sc = new Scanner(System.in);
    
    public int MostrarMenuLeerOpcion() {
        System.out.println("==== Menu Vehiculos ====");
        System.out.println("1. Agregar Vehiculo");
        System.out.println("2. Listar Vehiculo");
        System.out.println("3. Eliminar Vehiculo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");

        return sc.nextInt();
    }
    public Vehiculo leerDatosVehiculo(){

    VehiculoDAO dao = new VehiculoDAO();
    String placa;

    do {

        sc.nextLine();
        System.out.print("Ingresa la placa: ");
        placa = sc.nextLine();

        if(dao.existeVehiculo(placa)){
            System.out.println("⚠ La placa ya está registrada en la base de datos.");
        }

    } while(dao.existeVehiculo(placa));

    System.out.print("Ingresa el modelo: ");
    String modelo = sc.nextLine();

    System.out.print("Ingresa la marca: ");
    String marca = sc.nextLine();

    return new Vehiculo(placa, marca, modelo);
}

    public Vehiculo leerPlaca(){
        sc.nextLine();
        System.out.print("ingresa la placa: ");
        String placa = sc.nextLine();
        return new Vehiculo(placa, null, null);
    }

    public void mostrarVehiculos(VehiculoDAO vehiculoDAO){
        for (Vehiculo v : vehiculoDAO.obtenerVehiculos()) {
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("-----------------------");
        }
    }
    
    public void salir(){
            System.out.println("Saliendo del programa...");
            System.exit(0);  
  
    }


}