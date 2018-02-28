/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Ligne_commande;
import Entities.Panier;
import Entities.Produit;
import Entities.Utilisateur;
import Service.ServiceProduit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FXMLAfficherProduitController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label prix;
    @FXML
    private Label description;
    @FXML
    private Button retourBtn;
    @FXML
    private Button btn1;
     Panier panier=Panier.getInstance();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

     public void setImage(Image i)
   {
       img.setImage(i);
   }
    
   
    public void setPrix(String p)
    {
        prix.setText(p);
    }
    public void setDescription(String d)
    {
        description.setText(d);
    }

    @FXML
    private void addP(ActionEvent event) throws IOException {
        
        
        Utilisateur u=new Utilisateur();
       
        //Order o=new Order();
        
        
        ServiceProduit ps=new ServiceProduit();
        Produit p=ps.searchByName(description.getText());
        
        Ligne_commande c=new Ligne_commande(p.getId_produit(),1,p);
        //Command_Line c=new Command_Line(p.getId_product(),1,o,p);
        
        panier.addLine(c);
        //panier.removeLine(1);
        
        panier.show();
        
        
         FXMLLoader loader=new FXMLLoader(getClass().getResource("CartP.fxml"));
        
        Parent root=loader.load();
        CartPController cc=loader.getController();
        
        description.getScene().setRoot(root);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
          FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLAfficherListeProduit.fxml"));
                Parent root;
                root = loader.load();
                FXMLAfficherListeProduitController lp=loader.getController();
                btn1.getScene().setRoot(root);
                
                
    }
    
    
    
    
}
