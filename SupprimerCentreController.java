/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entities.Centre_esthetique;

import Service.ServiceCentreEsth;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class SupprimerCentreController implements Initializable {

    @FXML
    private TableView<Centre_esthetique> tableCentre;
 
    @FXML
    private TableColumn<Centre_esthetique, String> NomColumn;
    @FXML
    private TableColumn<Centre_esthetique, Integer> AdresseColumn;
    @FXML
    private TableColumn<Centre_esthetique, Integer> TelephoneColumn;
   

    /**
     * Initializes the controller class.
     */
    
    
      public static int id_centre_est ;
    @FXML
    private TextField NomCentreColumn;
    
    @FXML
    private TextField TelephoneCentreColumn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherAll();
    
        
    }    

    @FXML
    private void supprimerCentreEsth(ActionEvent event) {
      try {
            ServiceCentreEsth sa = new ServiceCentreEsth() ;
            sa.supprimerCentreEsth(id_centre_est);
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                 alert.setTitle("supprimer Centre ");
            alert.setHeaderText("Suppression effectuée");
            Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
           
            afficherAll();
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherAll()
    {
            try{
            
        
        ServiceCentreEsth c = new ServiceCentreEsth();
        tableCentre.setItems(c.displayCentre());
  
        NomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_centre_esth"));
        AdresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse_centre_esth"));
        TelephoneColumn.setCellValueFactory(new PropertyValueFactory<>("tel_centre_esth"));
      
        }catch(SQLException ex){
             Logger.getLogger(SupprimerCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    
    @FXML
      private void returnAdresse(MouseEvent event) {
        
     
        try {
            int s = tableCentre.getSelectionModel().getSelectedItem().getId_centre_esth();
            id_centre_est=s ;
            System.out.println(s);
            ServiceCentreEsth sa = new ServiceCentreEsth() ;
            Centre_esthetique a = new Centre_esthetique();
            a=sa.findById(s);
            //a.toString();
            NomCentreColumn.setText(a.getNom_centre_esth());
           
            TelephoneCentreColumn.setText(Integer.toString(a.getTel_centre_esth()));
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
                       }

    @FXML
    private void modifierCentre(MouseEvent event) {
                System.out.println("*****************"+id_centre_est+"*******************");
        if (!NomCentreColumn.getText().equals("") 
                && !TelephoneCentreColumn.getText().equals(""))
        {
            try {
                ServiceCentreEsth c = new ServiceCentreEsth();
                Centre_esthetique a = new Centre_esthetique() ;
                a=c.findById(id_centre_est);
                a. setNom_centre_esth(NomCentreColumn.getText());
             
                a.setTel_centre_esth(Integer.valueOf(TelephoneCentreColumn.getText()));
           
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                 alert.setTitle("modifier données ");
            alert.setHeaderText("Modification effectuée");
            Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            c.updateCentreEsth2(a);
            afficherAll();
        }
                
            } catch (SQLException ex) {
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
    
}
