package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Vehiculo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {
    

    public boolean existeVehiculo(String placa){
        Connection con = DataBase.ConexionDB.conectar();
        String sql = "SELECT COUNT(*) FROM vehiculo WHERE placa = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la existencia del vehículo: " + e.getMessage());
        }
        return false;
    }


    public void guardarVehiculo(Vehiculo vehiculo){

        if (existeVehiculo(vehiculo.getPlaca())) {
            System.out.println("Error: ya existe un vehículo con esa placa");
            return;
        }
        else{
            Connection con  = DataBase.ConexionDB.conectar();
            String sql = "INSERT INTO vehiculo (placa,marca,modelo)VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.executeUpdate();
            System.out.println("Vehículo guardado exitosamente");
            
        }
        
        catch (Exception e) {
            System.out.println("Error al guardar el vehículo: " + e.getMessage());
        }
        }
        

    }

    public List<Vehiculo>obtenerVehiculos(){
        List<Vehiculo> vehiculos = new ArrayList<>();
        Connection con = DataBase.ConexionDB.conectar();
        String sql = "SELECT * FROM vehiculo";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                Vehiculo vehiculo = new Vehiculo(placa, marca, modelo);
                vehiculos.add(vehiculo);

            }
        } catch (Exception e) {
            System.out.println("Error al obtener los vehículos: " + e.getMessage());
        }
        return vehiculos;
    }

    public void eliminarVehiculo(String placa){
        Connection con = DataBase.ConexionDB.conectar();
        String sql = "DELETE FROM vehiculo WHERE placa = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehículo eliminado exitosamente");
            } else {
                System.out.println("No se encontró un vehículo con la placa proporcionada");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el vehículo: " + e.getMessage());
        }
    }


}
