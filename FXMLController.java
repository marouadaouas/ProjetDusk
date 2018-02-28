/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.CarteBancaire;
import Entities.Parapharmacie;
import Entities.Utilisateur;
import Service.ServiceCarteBancaire;
import Service.ServicePara;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FXMLController implements Initializable {

    
    @FXML
    private TextField num_carteEntry;
    @FXML
    private TextField proprietereEntry;
     @FXML
    private JFXDatePicker dateExEntry;
      @FXML
    private TextField pass_carteEntry;
       @FXML
    private TextField SoldeEntry;
      @FXML
    private TextField banqueEntry;
        @FXML
    private TextField typeEntry;
          @FXML
    private Button BAjouter;
        
        CarteBancaire cb=new CarteBancaire();
        ServiceCarteBancaire scb=new ServiceCarteBancaire();
        Utilisateur u=new Utilisateur();
    @FXML
    private TableView<CarteBancaire> tbCarte;
    public static  int id_coo  ;

    public static int getId_coo() {
        return id_coo;
    }

    public static void setId_coo(int id_coo) {
        FXMLController.id_coo = id_coo;
    }
    @FXML
    private TableColumn<CarteBancaire, Integer> tb_num;
    @FXML
    private TableColumn<CarteBancaire, Integer> tbProp;
    @FXML
    private TableColumn<CarteBancaire, Date> tbDate;
    @FXML
    private TableColumn<CarteBancaire, Integer> tbMdp;
    @FXML
    private TableColumn<CarteBancaire, Float> tbSolde;
    @FXML
    private TableColumn<CarteBancaire, String> tbBanq;
    @FXML
    private TableColumn<CarteBancaire, String> tbType;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficherAll();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
     /*
    private void ajouter_carte(javafx.event.ActionEvent event)  {

        CarteBancaire cb=new CarteBancaire();
        ServiceCarteBancaire scb=new ServiceCarteBancaire();
        Utilisateur u=new Utilisateur();
    
        cb.setNum_carte(Integer.valueOf(num_carteEntry.getText()));
       
        cb.setId_u(Integer.valueOf(proprietereEntry.getText()));
        
        LocalDate db = dateExEntry.getValue();
        cb.setDate_expiration(java.sql.Date.valueOf(db));
        cb.setPass_carte(Integer.valueOf(pass_carteEntry.getText()));
        cb.setSolde(Float.valueOf(SoldeEntry.getText()));
        cb.setBanque(banqueEntry.getText());
        cb.setType(typeEntry.getText());

  
        scb.AjouterCarteBancaire(cb);

       

    }*/

   


    
    
    
/*
    @FXML
    private void update(ActionEvent event) {
        ServiceCarteBancaire sc = new ServiceCarteBancaire() ; 
        CarteBancaire cb = new CarteBancaire() ;
        
        try {
            cb=sc.searchById(id_coo) ;
            cb.setPass_carte(Integer.parseInt(pass_carteEntry.getText()));
            cb.setSolde(Float.parseFloat(SoldeEntry.getText()));
            if(!pass_carteEntry.getText().equals("") && !SoldeEntry.getText().equals(""))
            {
                sc.updateCarteBancaire(cb, id_coo);
                afficherAll();
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                         alert.setHeaderText("done with success");
                         Optional<ButtonType> result = alert.showAndWait();
            }
            
            else { 
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur champs vides");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    */
    
    public void afficherAll() throws SQLException
    {
       ServiceCarteBancaire sc = new ServiceCarteBancaire() ; 
        
        try {
            ObservableList<CarteBancaire> list=FXCollections.observableArrayList();
            list=sc.selectCarteBancaire();
            tbCarte.setItems(list) ;
            
              
                    tb_num.setCellValueFactory(new PropertyValueFactory<>("num_carte"));
                    tbProp.setCellValueFactory(new PropertyValueFactory<>("id_prop_user"));
                    tbDate.setCellValueFactory(new PropertyValueFactory<>("date_expiration"));
                    
       
                    tbMdp.setCellValueFactory(new PropertyValueFactory<>("pass_carte"));
                     tbSolde.setCellValueFactory(new PropertyValueFactory<>("solde"));
                   tbBanq.setCellValueFactory(new PropertyValueFactory<>("banque"));
                     tbType.setCellValueFactory(new PropertyValueFactory<>("type"));
        }
          catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
            
            

   

    @FXML
    private void ajouter_carte(ActionEvent event) {
        if (!num_carteEntry.getText().equals("") && !proprietereEntry.getText().equals("") 
                && !dateExEntry.getValue().equals("") && !pass_carteEntry.getText().equals("")
                && !SoldeEntry.getText().equals("") && !banqueEntry.getText().equals("")
                && !typeEntry.getText().equals(""))
        {
             ServiceCarteBancaire scb=new ServiceCarteBancaire();
              LocalDate db = dateExEntry.getValue();
            
             CarteBancaire cb=new CarteBancaire(Integer.parseInt(num_carteEntry.getText()), Integer.parseInt(proprietereEntry.getText()),
              java.sql.Date.valueOf(db),Integer.parseInt(pass_carteEntry.getText()),Float.parseFloat(SoldeEntry.getText()),
               banqueEntry.getText(),typeEntry.getText());
       System.out.println("aaaaaaaaaaaaaaa");
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
            alert.setHeaderText("done with success");
            Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
                try {
                    scb.AjouterCarteBancaire(cb);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
           num_carteEntry.clear();
            proprietereEntry.clear();
           // dateExEntry.clear();
            pass_carteEntry.clear();
            SoldeEntry.clear();
            banqueEntry.clear();
            typeEntry.clear();
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

    
    
     
        
    
    



}
            
        
    
    
        

    

