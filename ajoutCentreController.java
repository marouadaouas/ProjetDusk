/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Centre_esthetique;
import Service.ServiceCentreEsth;
import Utils.Controlesaisie;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class ajoutCentreController implements Initializable {

    @FXML
    private ImageView ImageLogo;
    @FXML
    private TextField NomText;
    @FXML
    private TextField AdresseText;
    @FXML
    private TextField TelText;
    @FXML
    private Button BtnAjout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterServiceCentreEsth(ActionEvent event)  {
        Controlesaisie s=new Controlesaisie();
          if (!NomText.getText().equals("") && !AdresseText.getText().equals("") 
                && !TelText.getText().equals("")){

    Centre_esthetique E=new Centre_esthetique(NomText.getText(),Integer.parseInt(AdresseText.getText()),Integer.parseInt(TelText.getText()),1);
    ServiceCentreEsth e = new ServiceCentreEsth();
    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("Centre ajouté avec succés");
    Optional<ButtonType> result=alert.showAndWait();
    if(result.get() == ButtonType.OK)
    {
        try{
            e.ajouterServiceCentreEsth(E);
        }catch(SQLException ex){
            Logger.getLogger(ajoutCentreController.class.getName()).log(Level.SEVERE,null,ex);
        }
        NomText.clear();
        AdresseText.clear();
        TelText.clear();
        
    }}   
        else
          { Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
          }
        

    }
    
}
