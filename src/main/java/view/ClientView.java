package view;

import controller.ClienteController;
import model.dto.ClienteDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {
    private JComboBox tipoIdentificacion;
    private JPasswordField contrasena;
    private JTextField numeroIdentificacion;
    private JTextField nombre;
    private JTextField usuario;
    private JTextField apellido;
    private JTextField numeroCelular;
    private JTextField email;
    private JTable table1;
    private JPanel panelMain;
    private JButton crearButton;

    public static void main(String[] args) {
        ClientView view = new ClientView();
        view.setContentPane(view.panelMain);
        view.setTitle("Nelson Castellanos");
        view.setSize(500, 700);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ClientView() {
        tipoIdentificacion.setModel(new DefaultComboBoxModel(new String[] {"CC", "TI", "NIT"}));
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDTO client = new ClienteDTO();
                client.setTipoID(tipoIdentificacion.getSelectedItem().toString());
                client.setNroID(numeroIdentificacion.getText());
                client.setNombre(nombre.getText());
                client.setApellido(apellido.getText());
                client.setUsuario(usuario.getText());
                client.setContrasena(contrasena.getText());
                client.setNroCelular(numeroCelular.getText());
                client.setCorreoElectronico(email.getText());
                ClienteController.create(client);
                clearForm();
                poblateList();
            }
        });
        poblateList();
    }

    private void poblateList(){
        DefaultTableModel model = createTable();
        for(ClienteDTO client : ClienteController.list()){
            model.addRow(new Object[]{
                    client.getTipoID(), client.getNroID(), client.getNombre(), client.getApellido(),
                    client.getUsuario(), client.getNroCelular(), client.getCorreoElectronico()
            });
        }
    }

    private void clearForm(){
        numeroIdentificacion.setText("");
        nombre.setText("");
        apellido.setText("");
        usuario.setText("");
        contrasena.setText("");
        numeroCelular.setText("");
        email.setText("");
    }

    private DefaultTableModel createTable(){
        DefaultTableModel tableModel = new DefaultTableModel();
        for(String columnName : new String[]{"Tipo de Identificación", "Número Identificación",
                "Nombre", "Apellido", "Usuario", "Número Celular", "Correo Electrónico"}){
            tableModel.addColumn(columnName);
        }
        table1.setModel(tableModel);
        return tableModel;
    }
}
