package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    
    public static Connection conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/consecionario";
            String usuario = "root";
            String password = "12345678";

            Connection conexion = DriverManager.getConnection(url, usuario, password);
            return conexion;



        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }


    }


}
