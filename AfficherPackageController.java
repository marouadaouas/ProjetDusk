/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Paquet;

import Service.ServicePaquet;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class AfficherPackageController implements Initializable {

    @FXML
    private TextField NomPaq;
    @FXML
    private TextField PrixPaq;
    @FXML
    private TextField ContenuPaq;
   
    @FXML
    private TableColumn<Paquet, Integer> PrixPaqColumn;
    @FXML
    private TableColumn<Paquet, String> ContenuPaqColumn;
 
    @FXML
    private TableView<Paquet> tablePaquets;
    @FXML
    private TableColumn<Paquet, String> NomPaqColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AfficherAll();
        
    }    
    
      public void AfficherAll(){
         try{
            
        
        ServicePaquet se = new ServicePaquet();
        tablePaquets.setItems(se.displayPaquet());
      
        NomPaqColumn.setCellValueFactory(new PropertyValueFactory<>("nom_packet"));
        PrixPaqColumn.setCellValueFactory(new PropertyValueFactory<>("prix_packet"));
        ContenuPaqColumn.setCellValueFactory(new PropertyValueFactory<>("contenu_packet"));
      
  
        }catch(SQLException ex){
             Logger.getLogger(AfficherPackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifierPaquet(ActionEvent event) {
    }
      
      
    
}
