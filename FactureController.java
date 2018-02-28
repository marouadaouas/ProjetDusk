/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commande;
import Entities.Ligne_commande;
import Entities.Panier;
import Entities.Produit;
import Entities.Utilisateur;
import static GUI.CartPController.lb1;
import static GUI.CartPController.prix;
import Service.ServiceCommande;
import Service.ServiceProduit;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FactureController implements Initializable {

    @FXML
    private JFXListView<HBox> list;
   
    @FXML
    private Button validC;
     ObservableList<HBox> l1= FXCollections.observableArrayList();
     Panier panier=Panier.getInstance();
     public static int idUser ;
    @FXML
    private JFXButton pdf;
    public static Utilisateur u1;
    @FXML
    private Label labelprix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        /*    date_commande.setEditable(false);

date_commande.setOnMouseClicked(e -> {
        if(!date_commande.isEditable())
            date_commande.hide();
    });*/
        // TODO
        for(Ligne_commande c:panier.p)
        {
            HBox hb =new HBox();
            
            CartPController cc=new CartPController();
      
        
         //
             
   Label lb1=new Label("          "+c.getP().getDescription_produit()+"        ");
            //
          Label lb2=new Label("          "+Integer.toString(c.quantite)+"        ");
            
          //lb2.setText(cc.lb2.getText());
          //System.out.println(lb2);
            //
//             c.setQuantity(Integer.parseInt(t.getText()));
         //  Label t1 = new Label( CartController.lb2.getText());
         //lb2  
           
           // Label lb3=new Label("    "+Float.toString(c.quantity*c.getProduct().getPrix())+" $      ");
          //  prix+=c.quantity*c.getProduct().getPrix();
          prix+=c.quantite*c.getP().getPrix_produit();
            System.out.println(prix);
            labelprix.setText(Float.toString(prix)+"$");
      //labelPrix.setText(Float.toString(CartPController.prix)+"$");
        //    lb4=lb6 ; 
            
            
          
          
            
   
            hb.getChildren().add(lb1);
       
              hb.getChildren().add(lb2);
           
          
          
          
            
            l1.add(hb);
            
            
           
            
        }
        
      
             list.setItems(l1);
            
    }    

    @FXML
    private void validerCommande(ActionEvent event) throws SQLException {
         {
        ServiceCommande os = new ServiceCommande();
        Commande co = new Commande (); 
       
   
            
         
//                or.setDate(Date.valueOf(date_commande.getValue()));
             Commande o;
             Date date1=new Date(12/01/1997);
            o = new Commande (date1,"en cours",CartPController.prix,12,1);
             System.out.println(o);
             os.AjouterCommande(o);
       
    
       
    }

   
    
}
}