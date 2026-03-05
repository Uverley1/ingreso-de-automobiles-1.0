package view;

import java.util.List;
import java.util.Scanner;

import model.Vehiculo;


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
        
        sc.nextLine();

        System.out.print("ingresa la placa: ");
        String placa = sc.nextLine();
        
        System.out.print("ingresa el modelo: ");
        String modelo = sc.nextLine();
        
        System.out.print("ingresa la marca: ");
        String marca = sc.nextLine();
        
        return new Vehiculo(placa, marca, modelo);

    }

    public void AgregarVehiculo(Vehiculo vehiculo) {
        System.out.println("Placa: " + vehiculo.getPlaca());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Modelo: " + vehiculo.getModelo());
    }

    public void mostrarVehiculos(List<Vehiculo> vehiculos){
        if(vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados.");
        }
        else{
            for (Vehiculo v : vehiculos) {
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("-----------------------");
            }
        }
    }

    public String LeerPlacaEliminar(){
        sc.nextLine();
        System.out.print("Ingrese la placa del vehiculo a eliminar: ");
        return sc.nextLine();
    }

}