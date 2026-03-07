package main;
import view.VehiculoView;
import DataBase.ConexionDB;
import controller.VehiculoController;

public class Main {
    public static void main(String[]args){
        VehiculoView view = new VehiculoView();
        VehiculoController controller = new VehiculoController(view);

        ConexionDB.conectar();

        controller.iniciar();
    }
}
