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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class AjoutPackageController implements Initializable {

    @FXML
    private TextField NomPackageText;
    @FXML
    private TextField PrixPackageText;
    @FXML
    private TextField ContenuPackageText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPackage(ActionEvent event) {
        
         if (!NomPackageText.getText().equals("") && !PrixPackageText.getText().equals("") 
                && !ContenuPackageText.getText().equals("")){

    Paquet P=new Paquet(NomPackageText.getText(),Float.parseFloat(PrixPackageText.getText()),ContenuPackageText.getText(),1);
    ServicePaquet p = new ServicePaquet();
    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("Centre ajouté avec succés");
    Optional<ButtonType> result=alert.showAndWait();
    if(result.get() == ButtonType.OK)
    {
        try{
            p.ajouterServicePaquet(P);
        }catch(SQLException ex){
            Logger.getLogger(ajoutCentreController.class.getName()).log(Level.SEVERE,null,ex);
        }
        NomPackageText.clear();
        PrixPackageText.clear();
        ContenuPackageText.clear();
        
    }}   
        else
          { Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
          }
        

    }
    }
    
    
    

