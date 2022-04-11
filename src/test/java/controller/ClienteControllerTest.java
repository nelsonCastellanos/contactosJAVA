package controller;

import model.MysqlConnect;
import model.dto.ClienteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private MysqlConnect instance;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void testList() {
        // Setup mock scenario
        Mockito.when(instance.getInstance()).thenThrow(new SQLException("Connection Exception"));
        Set<ClienteDTO> result = clienteController.list();
        Assertions.assertEquals(new HashSet<>(Arrays.asList(new ClienteDTO())), result);
    }
}

