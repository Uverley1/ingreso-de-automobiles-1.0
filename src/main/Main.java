package main;
import view.VehiculoView;
import controller.VehiculoController;
public class Main {
    public static void main(String[]args){
        VehiculoView view = new VehiculoView();
        VehiculoController controller = new VehiculoController(view);

        controller.iniciar();
    }
}
