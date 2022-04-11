package controller;

import model.MysqlConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteController {
    public static void main(String[] args) throws SQLException {
        MysqlConnect connect = MysqlConnect.getInstance();
        PreparedStatement statement = connect.preparedStatement("select * from table_name_val;");
        ResultSet val =  connect.execute(statement);
        while(val.next()){
            System.out.println(val.getInt("column_1"));
        }
    }
}
