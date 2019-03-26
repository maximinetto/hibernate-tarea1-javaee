package com.maximinetto;

import com.airhacks.afterburner.injection.Injector;
import com.maximinetto.connection.Conexion;
import com.maximinetto.entities.Cliente;
import com.maximinetto.view.clientemostrar.ClienteMostrarView;
import com.maximinetto.view.reserva.ReservaView;
import com.maximinetto.view.tablaClientes.TablaClientesView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Tarea1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Scene scene = new Scene(getReservaMostrar());
        
        stage.setTitle("Reserva");
        
        
        stage.setScene(scene);
        stage.show();
    }
    
   private Parent getClienteMostrar(){
       ClienteMostrarView clienteMostrarView = new ClienteMostrarView();
       return clienteMostrarView.getView();
        
   }
   
   private Parent getReservaMostrar(){
       ReservaView reservaView = new ReservaView();
       return reservaView.getView();
   }
   
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        Injector.forgetAll();
        Conexion.getInstance().getEntityManager().close();
        System.exit(0);
    }
    
    

}
