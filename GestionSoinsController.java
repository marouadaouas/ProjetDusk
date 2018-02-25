/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Estheticienne;
import Entities.Soins;
import Service.ServiceEstheticienne;
import Service.ServiceSoins;
import Service.Session;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class GestionSoinsController implements Initializable {

    @FXML
    private ComboBox<String> cbMaquillage;
    @FXML
    private ComboBox<String> cbManicure;
    @FXML
    private ComboBox<String> cbCoiffure;
    @FXML
    private ComboBox<String> cbHammam;
    @FXML
    private TextField NomSoins;
    @FXML
    private TextField PrixSoins;
    @FXML
    private TableColumn<Soins, String> NomSoinsColumn;
    @FXML
    private TableColumn<Soins, Float> PrixSoinsColumn;
    @FXML
    private TableView<Soins> tableSoins;
    @FXML
    private TableColumn<Soins, String> MaquillageSoinsColumn;
    @FXML
    private TableColumn<Soins, String> ManicureSoinsColumn;
    @FXML
    private TableColumn<Soins, String> CoiffureSoinsColumn;
    @FXML
    private TableColumn<Soins, String> HammamSoinsColumn;
    
    List<Soins> list_soins = new ArrayList<Soins>();

    
    String idSoin;
    @FXML
    private ComboBox<Estheticienne> cbEstheticienne;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        //cbEstheticienne.setValue("");
          ServiceSoins s=new ServiceSoins();
        cbMaquillage.getItems().addAll("eyeliner","fard à joues","rouge à lévres","khol","highlighter");
        cbManicure.getItems().addAll("nailart","french","metallique","mate");
        cbCoiffure.getItems().addAll("tresse","wavy","chignon");
        cbHammam.getItems().addAll("avec gommage","avec épilation");
        ServiceEstheticienne se=new ServiceEstheticienne();
        try {
            cbEstheticienne.setItems(se.displayEstheticienne());
        } catch (SQLException ex) {
            Logger.getLogger(GestionSoinsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
        afficher(); 
        
        
    }    
    
      void afficher() {
        ServiceSoins s = new ServiceSoins();
        tableSoins.setItems(s.selectSoins());

        NomSoinsColumn.setCellValueFactory(new PropertyValueFactory<>("nom_soins"));
        PrixSoinsColumn.setCellValueFactory(new PropertyValueFactory<>("prix_soins"));
         HammamSoinsColumn.setCellValueFactory(new PropertyValueFactory<>("hammam"));
        MaquillageSoinsColumn.setCellValueFactory(new PropertyValueFactory<>("maquillage"));
         ManicureSoinsColumn.setCellValueFactory(new PropertyValueFactory<>("manicure"));
          CoiffureSoinsColumn.setCellValueFactory(new PropertyValueFactory<>("coiffure"));
    }

    @FXML
    private void ajouterSoins(ActionEvent event) {
        ServiceSoins s = new ServiceSoins();
        ServiceEstheticienne se=new ServiceEstheticienne();
        Soins so = new Soins(NomSoins.getText(),Float.valueOf(PrixSoins.getText()),
                cbHammam.getValue(), cbMaquillage.getValue(),cbManicure.getValue(),cbCoiffure.getValue(),cbEstheticienne.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("done with success");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            s.ajouterServiceSoins(so);
        NomSoins.clear();
        PrixSoins.clear();
        cbHammam.setValue("Veuillez choisir le type");
        cbMaquillage.setValue("Veuillez choisir le type");
        cbManicure.setValue("Veuillez choisir le type");
        cbCoiffure.setValue("Veuillez choisir le type");
        
        }
        afficher();
    }

    @FXML
    private void modifierSoins(ActionEvent event) {
             
      String nomSo = NomSoins.getText();
      String prixSo=PrixSoins.getText();
       /////String positionBoutique = positionB.getText();

     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
      
           
            Soins so = new Soins(NomSoins.getText(),Float.valueOf(PrixSoins.getText()),
                cbHammam.getValue(), cbMaquillage.getValue(),cbManicure.getValue(),cbCoiffure.getValue());
             so.setId_soins(Integer.parseInt(idSoin));
                  ServiceSoins s = new ServiceSoins();
          try {
              s.updateSoins(so);
          } catch (SQLException ex) {
              Logger.getLogger(GestionSoinsController.class.getName()).log(Level.SEVERE, null, ex);
          }
//   ies.add(e);
            afficher();
       
    }
    }

    @FXML
    private void supprimerSoins(ActionEvent event) {
         if (!tableSoins.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression des soins");
            alert.setHeaderText("etes-vous sur que vous voulez supprimer le soin?:  "
                    + tableSoins.getSelectionModel().getSelectedItem().getNom_soins());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ServiceSoins soi=new ServiceSoins();
                try {
                    soi.supprimerSoins(tableSoins.getSelectionModel().getSelectedItem().getId_soins());
                } catch (SQLException ex) {
                    Logger.getLogger(GestionSoinsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                afficher();
            }

        }
    }
    
}
