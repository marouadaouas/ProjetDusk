/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Centre_esthetique;
import Entities.Estheticienne;
import Service.ServiceCentreEsth;
import Service.ServiceEstheticienne;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class AjoutEstheticienneController implements Initializable {

    @FXML
    private TextField NomID;
    @FXML
    private TextField PrenomID;
    @FXML
    private TextField SpecialiteID;
    @FXML
    private ComboBox<String> cbCentre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbCentre.setValue("");
        ServiceCentreEsth ce=new ServiceCentreEsth();
        cbCentre.setItems(ce.displayEstheticiennenom(id_esth_soin));
    }    

    @FXML
    private void ajoutEsthBtn(ActionEvent event) {
        if (!NomID.getText().equals("") && !PrenomID.getText().equals("") 
                && !SpecialiteID.getText().equals("") &&!cbCentre.getValue().equals("")){
            ServiceCentreEsth ce=new ServiceCentreEsth();

    Estheticienne E=new Estheticienne(NomID.getText(),PrenomID.getText(),SpecialiteID.getText(),(ce.findByNom(cbCentre.getValue())));
    ServiceEstheticienne e = new ServiceEstheticienne();
    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("Centre ajouté avec succés");
    Optional<ButtonType> result=alert.showAndWait();
    if(result.get() == ButtonType.OK)
    {
        try{
            e.ajouterServiceEstheticienne(E);
        }catch(SQLException ex){
            Logger.getLogger(ajoutCentreController.class.getName()).log(Level.SEVERE,null,ex);
        }
        NomID.clear();
        PrenomID.clear();
        SpecialiteID.clear();
        
    }}   
        else
          { Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
          }
        

    }
    
    }
    

