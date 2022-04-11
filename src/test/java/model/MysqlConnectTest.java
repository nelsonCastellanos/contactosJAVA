package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MysqlConnectTest {
    @Mock
    MysqlConnect instance;
    @Mock
    Connection connection;
    @InjectMocks
    MysqlConnect mysqlConnect;

    @Test
    void testGetInstance() {
        when(instance.dataSource()).thenReturn(null);

        MysqlConnect result = MysqlConnect.getInstance();
        Assertions.assertEquals(new MysqlConnect(), result);
    }

    @Test
    void testExecute() throws SQLException {
        ResultSet result = mysqlConnect.execute(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testPreparedStatement() throws SQLException {
        PreparedStatement result = mysqlConnect.preparedStatement("sql");
        Assertions.assertEquals(null, result);
    }
}
