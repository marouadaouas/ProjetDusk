/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class GestionCentreController implements Initializable {

    @FXML
    private Button ajoutCentreBtn;
    @FXML
    private Button afficherCentreBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterCentreE(ActionEvent event) {
          Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("ajoutCentre.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("ajout");
            s.setScene(scene);
            s.show();
    }

    @FXML
    private void afficherCentre(ActionEvent event) {
        try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("supprimerCentre.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("affichage");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rechercherCentre(ActionEvent event) {
        try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("API");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void noterCentre(ActionEvent event) {
        try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("Rating.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("API");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void menu(ActionEvent event) {
          try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("Menu");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchCentre(ActionEvent event) {
        try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("searchCentre.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("recherche synchrone");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
