package controller;

import model.MysqlConnect;
import model.dto.ClienteDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClienteController {

    public static Set<ClienteDTO> list(){
        Set<ClienteDTO> clients = new HashSet<>();
        try {
            MysqlConnect connect = MysqlConnect.getInstance();
            String query = "Select * from cliente;";
            PreparedStatement statement = connect.preparedStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ClienteDTO client = new ClienteDTO();
                client.setId(Integer.parseInt(resultSet.getString("id")));
                client.setTipoID(resultSet.getString("tipoID"));
                client.setNroID(resultSet.getString("nroID"));
                client.setNombre(resultSet.getString("nombre"));
                client.setApellido(resultSet.getString("apellido"));
                client.setUsuario(resultSet.getString("usuario"));
                client.setContrasena(resultSet.getString("contrasena"));
                client.setNroCelular(resultSet.getString("nroCelular"));
                client.setCorreoElectronico(resultSet.getString("correoElectronico"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static void create(ClienteDTO cliente) {
        MysqlConnect connect = MysqlConnect.getInstance();
        String query = "insert into cliente (tipoID, nroID, nombre, apellido, usuario, contrasena, nroCelular, correoElectronico)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connect.preparedStatement(query);
            statement.setString(1, cliente.getTipoID());
            statement.setString(2, cliente.getNroID());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellido());
            statement.setString(5, cliente.getUsuario());
            statement.setString(6, cliente.getContrasena());
            statement.setString(7, cliente.getNroCelular());
            statement.setString(8, cliente.getCorreoElectronico());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
