package model;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Conector para la base de datos MYSQL Server, SINGLETON
 */
public class MysqlConnect {

    /**
     * Static variable reference of type Singleton
     */
    private static MysqlConnect instance;
    private Connection connection = null;

    public MysqlConnect() {
        try {
            connection = dataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Static method to create instance of Singleton class
     * @return
     */
    public static MysqlConnect getInstance()
    {
        if (instance == null)
            instance = new MysqlConnect();
        return instance;
    }

    /**
     * Base de datos a la cual se va a realizar la conexión.
     * @return valor de fuente de datos.
     */
    MysqlDataSource dataSource(){
        MysqlDataSource connection = new MysqlDataSource();
        connection.setUser("root");
        connection.setPassword("");
        connection.setServerName("127.0.0.1");
        connection.setDatabaseName("umb");
        return connection;
    }


    /**
     * Ejecutar QUERY en base de datos
     * @throws SQLException Error al ejecutar query.
     * @return Set de valores de la consulta realizada.
     */
    public ResultSet execute(PreparedStatement statement ) throws SQLException {
        ResultSet resultSet =  statement.executeQuery();
        return resultSet;
    }

    /**
     * Preparara SQL
     * @param sql Query al realizar ejecución.
     * @return SQL Parametrizable
     * @throws SQLException
     */
    public PreparedStatement preparedStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
