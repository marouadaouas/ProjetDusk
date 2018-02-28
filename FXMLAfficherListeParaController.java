/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Parapharmacie;
import Service.ServicePara;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
//import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FXMLAfficherListeParaController implements Initializable {

    @FXML
    private TableView<Parapharmacie> tbPara;
    @FXML
    private TableColumn<?, ?> tbnom;
    @FXML
    private TableColumn<?, ?> tbadresse;
    @FXML
    private TableColumn<?, ?> tbtel;
    @FXML
    private TableColumn<?, ?> tbmail;
    @FXML
    private TableColumn<?, ?> tbHO;
    @FXML
    private TableColumn<?, ?> tbHF;
    @FXML
    private TableColumn<?, ?> idRespP;
     @FXML
    private TextField rechercheEntry;
   
    
    public static int val_select ; 
    
     ObservableList<Parapharmacie> masterData=FXCollections.observableArrayList();
     private ObservableList<Parapharmacie> filteredData = FXCollections.observableArrayList();
    @FXML
    private Button tbnSupp;
   

    public FXMLAfficherListeParaController() {
        // Initially add all data to filtered data
        filteredData.addAll(masterData);
         // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<Parapharmacie>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Parapharmacie> change) {
                try {
                    updateFilteredData();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLAfficherListeParaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
        
        
    }
     
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServicePara sp = new ServicePara() ;
        
        
        try {
           
           masterData=sp.selectPara();
            tbPara.setItems(masterData) ;
            
              
                    tbnom.setCellValueFactory(new PropertyValueFactory<>("nom_para"));
                    tbadresse.setCellValueFactory(new PropertyValueFactory<>("adresse_para"));
                    tbtel.setCellValueFactory(new PropertyValueFactory<>("num_tel_para"));
                    tbmail.setCellValueFactory(new PropertyValueFactory<>("email_para"));
                    tbHO.setCellValueFactory(new PropertyValueFactory<>("horaire_ouverture_para"));
                    tbHF.setCellValueFactory(new PropertyValueFactory<>("horaire_fermeture_para"));
                    idRespP.setCellValueFactory(new PropertyValueFactory<>("Id_resp_para"));
                    System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm");
        
         
  
                    
                       
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficherListeParaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }    
    
    
          
 /**
     * Updates the filteredData to contain all data from the masterData that
     * matches the current filter.
     */
    private void updateFilteredData() throws IOException {
        filteredData.clear();

        for (Parapharmacie p : masterData) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }
/**
     * Returns true if the person matches the current filter. Lower/Upper case
     * is ignored.
     * 
     * @param 
     * @return
     */
    private boolean matchesFilter(Parapharmacie p) throws IOException {
        String filterString = rechercheEntry.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }
     String lowerCaseFilterString = filterString.toLowerCase();

        if (p.getNom_para().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } 

        return false; // Does not match
    }
private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Parapharmacie, ?>> sortOrder = new ArrayList<>(tbPara.getSortOrder());
        tbPara.getSortOrder().clear();
        tbPara.getSortOrder().addAll(sortOrder);
    }
    @FXML
 private void filterData() throws SQLException{
     
     ServicePara sp = new ServicePara() ;
     masterData=sp.selectPara();
            tbPara.setItems(masterData) ;
            
              
                    tbnom.setCellValueFactory(new PropertyValueFactory<>("nom_para"));
                    tbadresse.setCellValueFactory(new PropertyValueFactory<>("adresse_para"));
                    tbtel.setCellValueFactory(new PropertyValueFactory<>("num_tel_para"));
                    tbmail.setCellValueFactory(new PropertyValueFactory<>("email_para"));
                    tbHO.setCellValueFactory(new PropertyValueFactory<>("horaire_ouverture_para"));
                    tbHF.setCellValueFactory(new PropertyValueFactory<>("horaire_fermeture_para"));
                    idRespP.setCellValueFactory(new PropertyValueFactory<>("Id_resp_para"));
      // Add filtered data to the table
        tbPara.setItems(filteredData);

        // Listen for text changes in the filter text field
        rechercheEntry.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                try {
                    updateFilteredData();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLAfficherListeParaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
 }
  

    @FXML
    private void select(MouseEvent event) throws IOException {
        
         
        Parapharmacie p1 = tbPara.getSelectionModel().getSelectedItem();
        System.out.println(p1);
        val_select = p1.getId_para();
        System.out.println(val_select);
        
         FXMLLoader loader1 = new FXMLLoader(getClass().getResource("FXMLPara.fxml"));
         //Parent root1 = loader1.load();
         FXMLParaController ssc1 = loader1.getController() ; 
         ssc1.setId_tab(val_select);
         System.out.println("oooooooooooooooooooooooooooooo");
        //System.out.println(ssc1.);
        Parent root1 = loader1.load();
        tbnSupp.getScene().setRoot(root1);
    }

    @FXML
    private void Delete(ActionEvent event) {
    }
    
}
