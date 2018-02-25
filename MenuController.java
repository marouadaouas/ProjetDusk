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
public class MenuController implements Initializable {

    @FXML
    private Button CentreEsthBtn;
    @FXML
    private Button SoinBtn;
    @FXML
    private Button packageBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gererCentreEsth(ActionEvent event) {
      Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionCentre.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("gestion");
            s.setScene(scene);
            s.show();
    }

    @FXML
    private void gererSoins(ActionEvent event) {
       try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("GestionSoins.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("Soin");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void gererPackage(ActionEvent event) {
        try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("GestionPackages.fxml"));
       
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("ajout");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GestionEsthBtn(ActionEvent event) {
        try {
            Parent root = null;
            
            root = FXMLLoader.load(getClass().getResource("GestionEstheticienne.fxml"));
     
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("gestion");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
