/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Centre_esthetique;
import Entities.Estheticienne;
import static GUI.SupprimerCentreController.id_centre_est;
import Service.ServiceCentreEsth;
import Service.ServiceEstheticienne;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class AfficherEstheticienneController implements Initializable {

    @FXML
    private TableColumn<Estheticienne, String> NomColumn;
    @FXML
    private TableColumn<Estheticienne, String> PrenomColumn;
    @FXML
    private TableColumn<Estheticienne, String> SpecialiteColumn;
    @FXML
    private TableView<Estheticienne> tableEstheticiennes;
    @FXML
    private TextField NomEsthColumn;
    @FXML
    private TextField PrenomEsthColumn;
    @FXML
    private TextField SpecialiteEsthColumn;

    
      public static int id_est ;
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
            
        
        ServiceEstheticienne se = new ServiceEstheticienne();
        tableEstheticiennes.setItems(se.displayEstheticienne());
        NomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_esth"));
        PrenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom_esth"));
        SpecialiteColumn.setCellValueFactory(new PropertyValueFactory<>("specialite_esth"));
        
        }catch(SQLException ex){
             Logger.getLogger(AfficherEstheticienneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifierEstheticienne(MouseEvent event) {
         System.out.println("*****************"+id_est+"*******************");
        if (!NomEsthColumn.getText().equals("") 
                && !PrenomEsthColumn.getText().equals("")&&!SpecialiteEsthColumn.getText().equals(""))
        {
            try {
                ServiceEstheticienne c = new ServiceEstheticienne();
                Estheticienne a = new Estheticienne() ;
                a=c.findById(id_est);
                a. setNom_esth(NomEsthColumn.getText());
             
                a.setPrenom_esth(PrenomEsthColumn.getText());
                a.setSpecialite_esth(SpecialiteEsthColumn.getText());
           
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                 alert.setTitle("modifier données ");
            alert.setHeaderText("Modification effectuée");
            Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            c.updateEstheticienne2(a);
            AfficherAll();
        }
                
            }catch (SQLException ex) {
                Logger.getLogger(SupprimerCentreController.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
        
         else 
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur champs vides");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void returnEstheticienne(MouseEvent event) {
        
        try {
            int s = tableEstheticiennes.getSelectionModel().getSelectedItem().getId_esth();
            id_est=s ;
            System.out.println(s);
            ServiceEstheticienne sa = new ServiceEstheticienne() ;
            Estheticienne a = new Estheticienne();
            a=sa.findById(s);
            //a.toString();
            NomEsthColumn.setText(a.getNom_esth());
            PrenomEsthColumn.setText(a.getPrenom_esth());
            SpecialiteEsthColumn.setText(a.getSpecialite_esth());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEstheticienneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      
        
          
        
     
    }
    

