/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.CarteBancaire;
import Entities.Produit;
import Service.ServiceCarteBancaire;
import Service.ServiceProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FXMLAjouterProduitController implements Initializable {

    @FXML
    private TextField imgEntry;
    @FXML
    private TextField prixEntry;
    @FXML
    private TextField DescEntry;
     @FXML
    private TextField quantiteEntry;
     @FXML
    private TextField categorieEntry;
    @FXML
    private TextField id_user;
                      
    @FXML
    private Button ajouterProduit;
    @FXML
    private Button afficherListe;
    @FXML
    private Label tcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterProduit(ActionEvent event) {
        if (!prixEntry.getText().equals("") && !DescEntry.getText().equals("") 
                && !imgEntry.getText().equals("") && !quantiteEntry.getText().equals("")
                && !categorieEntry.getText().equals("") && !id_user.getText().equals(""))
        {
             ServiceProduit sp=new ServiceProduit();
            
            
             Produit p=new Produit( Float.parseFloat(prixEntry.getText()),
              Integer.parseInt(quantiteEntry.getText()),DescEntry.getText() ,(categorieEntry.getText()),
                     Integer.parseInt(id_user.getText()),(imgEntry.getText()) );
       
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
            alert.setHeaderText("done with success");
            Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
                try {
                    sp.AjouterProduit(p);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
           imgEntry.clear();
            prixEntry.clear();
           
            DescEntry.clear();
            quantiteEntry.clear();
            categorieEntry.clear();
            id_user.clear();
            
           
            System.out.println("\n \n c bonnnnnnnnnnn wleeyyyyyyyyyyyy !!! ");
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
    private void afficherListe(ActionEvent event) throws Exception {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAfficherListeProduit.fxml"));
     //FXMLLoader loader = ma.getRoot();
      //FXMLLoader loader = new FXMLLoader();
       System.out.println("-----------------------------------");
     // Parent root1 = ma.getRoot() ;
        System.out.println("-----------------------------------");
      Parent root = loader.load();
     tcode.getScene().setRoot(root);
    }
    }
    

