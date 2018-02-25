/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Centre_esthetique;
import Service.ServiceCentreEsth;
import Utils.DataSource;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.TextFields;
import java.net.URL;
import java.sql.Connection;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Maroua
 */
public class SearchCentreController implements Initializable {

    @FXML
    private TextField motCle;
    @FXML
    private TableView<Centre_esthetique> tabCentres;
    @FXML
    private TableColumn<Centre_esthetique, String> nomCentreRecherche;
    @FXML
    private TableColumn<Centre_esthetique, Integer> AdresseCentreRecherche;
    @FXML
    private TableColumn<Centre_esthetique, Integer> TelephoneCentreRecherche;

    /**
     * Initializes the controller class.
     */
     public String getMotCle() {
        return motCle.getText();
    }
      Connection conn;
    private ObservableList<Centre_esthetique> clist;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficheall();
        ServiceCentreEsth se=new ServiceCentreEsth();
        TextFields.bindAutoCompletion(motCle,se.liste_centre());
        
    }    

    
     public void afficheall()
    {
            try{
            
        
        ServiceCentreEsth c = new ServiceCentreEsth();
        tabCentres.setItems(c.displayCentre());
  
        nomCentreRecherche.setCellValueFactory(new PropertyValueFactory<>("nom_centre_esth"));
        AdresseCentreRecherche.setCellValueFactory(new PropertyValueFactory<>("adresse_centre_esth"));
        TelephoneCentreRecherche.setCellValueFactory(new PropertyValueFactory<>("tel_centre_esth"));
      
        }catch(SQLException ex){
             Logger.getLogger(SearchCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void motCle(ActionEvent event) {
         try {
            clist = FXCollections.observableArrayList();
            conn = DataSource.getInstance().getConnection();
            // Publicite p = null;
            String req = "select * from Centre_esthetique where nom_centre_esth = ?";
            PreparedStatement preparedStatement;
            
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setString(1, motCle.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Centre_esthetique c= new Centre_esthetique();
              
                c.setNom_centre_esth(resultSet.getString("nom_centre_esth"));
                c.setAdresse_centre_esth(resultSet.getInt("adresse_centre_esth"));
                  c.setTel_centre_esth(resultSet.getInt("tel_centre_esth"));
             
                
                clist.add(c);
            }
            tabCentres.setItems(clist);
        } catch (SQLException ex) {
            Logger.getLogger(SearchCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returnRechercheCentre(MouseEvent event) {
        
    }
    
}
