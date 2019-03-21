/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximinetto.view.paginationCliente;

import com.maximinetto.entities.Cliente;
import com.maximinetto.service.ClienteCRUDService;
import com.maximinetto.view.tablaClientes.TablaClientesPresenter;
import com.maximinetto.view.tablaClientes.TablaClientesView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javax.inject.Inject;

/**
 *
 * @author Administrador
 */
public class PaginationClientePresenter implements Initializable {

    private ResourceBundle resources = null;

    @FXML
    private Pagination paginatorCliente;
    
    @Inject
    private ClienteCRUDService clienteCRUDService;

    private TablaClientesPresenter tablaClientesPresenter;

    private static final int ITEMS_PER_PAGE = 10;
     
    private  TableView<Cliente> tblClientes;
    private Parent tablaClientesViewParent;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        tablaClientesViewParent = getTablaClientes();
        tblClientes = tablaClientesPresenter.getTablaCliente();
        inicializarDatos();
    }

    private Parent getTablaClientes() {
        TablaClientesView tablaClientesView = new TablaClientesView();
        tablaClientesPresenter = tablaClientesView.getRealPresenter();
        return  tablaClientesView.getView();
   }
    
    private void inicializarDatos(){
        mostrarPaginado();
    }
    
     private void mostrarPaginado(){
        
        paginatorCliente.setPageFactory(this::createPage);
        
    }
     
      private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * ITEMS_PER_PAGE;
        ObservableList<Cliente> listaClientePaginada = this.clienteCRUDService.mostrarPaginado(ITEMS_PER_PAGE, fromIndex);
        tblClientes.setItems(listaClientePaginada);
        double paginas = clienteCRUDService.getTotalClientes().doubleValue() / ITEMS_PER_PAGE;
        int totalPages = (int) Math.ceil(paginas);
        paginatorCliente.setPageCount(totalPages);
        return tablaClientesViewParent;
    }

    public static int getITEMS_PER_PAGE() {
        return ITEMS_PER_PAGE;
    }

    public TableView<Cliente> getTblClientes() {
        return tblClientes;
    }   
    
}
