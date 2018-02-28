/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Produit;
import Service.ServiceProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FXMLAfficherListeProduitController implements Initializable {

    @FXML
    private GridPane gridP;
    @FXML
    private TextArea t;
    @FXML
    private Label pr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         List<ImageDataObjs> imageURLs=makeDBCall() ; 
         System.out.println("pppppppppppppppppppppppppppppppppp");
        ServiceProduit ps=ServiceProduit.getInstance();
        
         
         
       gridP.setPadding(new Insets(10,10,10,10));
       gridP.setHgap(200);
       gridP.setVgap(200);

    int cols=2, colCnt = 0, rowCnt = 0;
    
    for (int i=0; i<imageURLs.size(); i++) {
        VBox v=new VBox();
        v.getChildren().add(imageURLs.get(i).imageView);
        v.getChildren().add(new Label(imageURLs.get(i).description));
        v.getChildren().add(new Label(Float.toString(imageURLs.get(i).price)));
        //v.getChildren().add(imageURLs.get(i).rate);
        
        Produit p=ps.searchByName(imageURLs.get(i).description);
    /*    imageURLs.get(i).rate.ratingProperty().addListener(new ChangeListener<Number>()
                   {
                       @Override
                       public void changed(ObservableValue<? extends Number> observable,Number oldValue,Number newValue)
                       {
                           try{
                               ps.rate(p.getId_product(),(double)newValue);
                           }
                           catch(SQLException ex)
                           {
                               System.out.println("Probleme de connexion");
                           }
                       }
                    }
                );
        */
        
        gridP.add(v, colCnt, rowCnt);
        colCnt++;
        if (colCnt>cols) {
            rowCnt++;
            colCnt=0; 
        }   
    }
    
        //Passer le nom du produit au click
    for (int i=0; i<imageURLs.size(); i++) { 
        String description_produit=imageURLs.get(i).description;
        imageURLs.get(i).imageView.addEventHandler(MouseEvent.MOUSE_CLICKED,event->
        {
           t.setText(description_produit);
           goProduct(description_produit);
        }
        );
                }
    
    //passer a la page showProduct
    
    
    
    }
 public void goProduct(String description_produit) 
    {
        if(t.getText()!=" ")
        {  System.out.println("i'm hereeeeeeeeeeeeeeee");
            try {
                System.out.println("chui laaaaaaaaaaaaaa");
                FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLAfficherProduit.fxml"));
                Parent root;
                root = loader.load();
                FXMLAfficherProduitController sp=loader.getController();
                 ServiceProduit ps=ServiceProduit.getInstance();
                 Produit p=ps.searchByName(description_produit);
       
               sp.setPrix(Float.toString(p.getPrix_produit()));
               sp.setDescription(p.getDescription_produit());
               URL url=getClass().getResource(p.getImg_produit());
               Image img = new Image(url.toExternalForm());
               sp.setImage(img);
                
              
                gridP.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAfficherListeProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         
    }
    }   
       private List<ImageDataObjs> makeDBCall() {
    List<ImageDataObjs> imageDataObjList = new ArrayList<>();
  
    ServiceProduit ps=new ServiceProduit();
        List<Produit> lp=new ArrayList();
       
            lp=ps.show();
           
     
          
        
       for(Produit p:lp)
       { 
           String a1=p.getImg_produit() ;
           System.out.println(a1);
           
           String a2=p.getDescription_produit() ; 
           System.out.println(a2);
           float a3=p.getPrix_produit();
           System.out.println(a3);
           
           ImageDataObjs i =new ImageDataObjs(a1,a2,a3);
          
        
        
         System.out.println("aaaaaaaaaaaaaaaaaaa");
           
         imageDataObjList.add(i);
           
       }

           
      
    return imageDataObjList;
}
      
 
       
       class ImageDataObjs {
     // final ImageView imageView;
        //  String imgURL, price;
       // @FXML
      public ImageView imageView;
      public String imgURL,description;
      public float price;
      //Rating rate=new Rating();
      
      public ImageDataObjs ()
      {};

    public ImageDataObjs(String imgURL,String description,float price) {
        this.imgURL = imgURL;
        this.description=description;
        this.price = price;
        //this.rate=rate;
    
        URL url=getClass().getResource(imgURL);
        //System.out.println(url);
        Image image = new Image(url.toExternalForm());
        
        this.imageView = new ImageView(image);
        
        
        
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
    }

        @Override
        public String toString() {
            return "ImageDataObjs{" + ", imgURL=" + imgURL + ", description=" + description + ", price=" + price + '}';
        }

    
       
       
       }
        

}
