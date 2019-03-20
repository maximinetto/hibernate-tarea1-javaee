package com.maximinetto;

import com.maximinetto.connection.Conexion;
import com.maximinetto.entities.Cliente;
import com.maximinetto.service.ClienteService;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable {
    
    @FXML
    private TableView<ClienteService> tblClientes;

    @FXML
    private TableColumn<ClienteService, Integer> id;

    @FXML
    private TableColumn<ClienteService, Integer> dni;

    @FXML
    private TableColumn<ClienteService, String> nombre;

    @FXML
    private TableColumn<ClienteService, String> dir;

    @FXML
    private TableColumn<ClienteService, String> tel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<ClienteService, Integer>("id"));
        dni.setCellValueFactory(new PropertyValueFactory<ClienteService, Integer>("dni"));
        nombre.setCellValueFactory(new PropertyValueFactory<ClienteService, String>("nombre"));
        dir.setCellValueFactory(new PropertyValueFactory<ClienteService, String>("dir"));
        tel.setCellValueFactory(new PropertyValueFactory<ClienteService, String>("tel"));
        find();
    }    
    
    public void mostrarClientes(){
        List<Cliente> clientes = Conexion.getInstance().select("SELECT c FROM Cliente c", Cliente.class);
        List<ClienteService> clientesService = convertToClienteService(clientes);
        tblClientes.setItems(FXCollections.observableArrayList(clientesService));
        
    }
    
    public void mostrarPaginado(){
        Map<List<Cliente>, Integer> clientesMap = Conexion.getInstance().pageable(Cliente.class, 10, 1);
        List<Cliente> clientes = clientesMap.keySet().stream().findFirst().get();
        List<ClienteService> clientesService = convertToClienteService(clientes);
        tblClientes.setItems(FXCollections.observableArrayList(clientesService));
        System.out.println("Total clientes: " + clientesMap.get(clientes));
    }
    
    public void find(){
        Map<String, Object> valores = new HashMap<>();
        valores.put("nombre", "%a%");
        valores.put("dir", "%3%");
        List<Cliente> clientes = Conexion.getInstance().find("SELECT c FROM Cliente c WHERE UPPER(c.nombre) like UPPER(:nombre) or UPPER(c.dir) like UPPER(:dir)", 
                Cliente.class, valores);
        List<ClienteService> clientesService = convertToClienteService(clientes);
        tblClientes.setItems(FXCollections.observableArrayList(clientesService));
    }
    
    private List<ClienteService> convertToClienteService(List<Cliente> clientes) {
        List<ClienteService> clientesService = clientes.stream()
                .map(c -> {
                    ClienteService clienteService = new ClienteService(c.getIdCliente(), c.getDni(), c.getNombre(), c.getDir(), c.getTel());
                    return clienteService;
                }).collect(Collectors.toList());
        return clientesService;
    }
}
