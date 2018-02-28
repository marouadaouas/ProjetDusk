/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Ligne_commande;
import Entities.Panier;
import Entities.Produit;
import Service.ServiceProduit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class CartPController implements Initializable {

    public ObservableList<Ligne_commande> l= FXCollections.observableArrayList();
    @FXML
    private AnchorPane cont;
    @FXML
    private ListView<HBox> liste;
    @FXML
    private Button bt4;
    @FXML
     Label lb4;
    @FXML
    private Button btnR;
     public static Label lb1;
    public static Label lb2;
    public static float prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ImageView imageView = new ImageView();
        ObservableList<HBox> l1= FXCollections.observableArrayList();
        
        Panier panier=Panier.getInstance();
        
        float prix=0;
       
        
       for( Ligne_commande c : panier.p) 
        { 
           
            HBox hb =new HBox();
            
            ImageView im=new ImageView();
            URL url2=getClass().getResource(c.getP().getImg_produit());
            Image image = new Image(url2.toExternalForm());
            im.setImage(image);
            im.setFitHeight(150);
            im.setFitWidth(150);
            
            Label lb1=new Label(c.getP().getDescription_produit());
            Label lb2=new Label("          "+Integer.toString(c.quantite)+"        ");
            TextField t=new TextField();
           
            
            Label lb3=new Label("    "+Float.toString(c.quantite*c.getP().getPrix_produit())+" $      ");
            prix+=c.quantite*c.getP().getPrix_produit();
            lb4.setText(Float.toString(prix)+"$");
            Button bt1=new Button("supprimer");
            
            
            
            bt1.addEventHandler(MouseEvent.MOUSE_CLICKED,event->
              {
                  
                  panier.removeLine(c);
                  
                  
                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("CartP.fxml"));
                    Parent root;
                    root = loader.load();
                    CartPController sp=loader.getController();
                    cont.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(CartPController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              }
                    );
            t.addEventHandler(MouseEvent.MOUSE_EXITED, event->
            {
                c.setQuantite(Integer.parseInt(t.getText()));
                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("CartP.fxml"));
                    Parent root;
                    root = loader.load();
                    CartPController sp=loader.getController();
                    cont.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(CartPController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            );
           
            
            hb.getChildren().add(im);
            hb.getChildren().add(lb1);
            hb.getChildren().add(lb2);
            hb.getChildren().add(t);
            hb.getChildren().add(lb3);
            hb.getChildren().add(bt1);
            
            System.out.println("aa33333333333333333333");
          
                     
            l1.add(hb);     
            
            
    
        }
        
      liste.setItems(l1);
        
    }    

   /* private void retour(ActionEvent event) throws IOException {
       
    }*/

    //calider le panier et ajouter une commande 
    @FXML
    private void passOrder(ActionEvent event) throws IOException {
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Facture.fxml"));
                Parent root;
                root = loader.load();
                FactureController fc=loader.getController();
                
                cont.getScene().setRoot(root);
        
        
    }


    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLAfficherProduit.fxml"));
                Parent root;
                root = loader.load();
                FXMLAfficherProduitController sp=loader.getController();
                
                cont.getScene().setRoot(root);
    }
    
}
