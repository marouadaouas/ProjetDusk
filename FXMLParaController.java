/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Parapharmacie;
import Service.ServicePara;
import Utils.ControleSaisie;
//import com.jfoenix.controls.JFXDatePicker;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
//import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXTimePicker;
import java.time.LocalTime;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Esprit1
 */
public class FXMLParaController implements Initializable {

    @FXML
    private TextField nomEntry;
    @FXML
    private TextField id_respEntry;
    @FXML
    private TextField telEntry;
    @FXML
    private TextField EmailEntry;
    @FXML
    private JFXTimePicker heureOuvrEntry;
    @FXML
    private TextField AdresseEntry;
    @FXML
    private JFXTimePicker heureFermEntry;
    @FXML
    private Label nom_p;
    
     private int id_par ;
    
    
    
    public static int id_tab = 0 ; 

    public static int getId_tab() {
        return id_tab;
    }

    public static void setId_tab(int id_tab) {
        FXMLParaController.id_tab = id_tab;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        id_par=id_utiliser();
        try {
            // TODO
            showDetails();
        } catch (ParseException ex) {
            Logger.getLogger(FXMLParaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     private int id_utiliser ()
    {
        int id_utiliser =0;
        if(id_tab==0)
        {
            ServicePara ss = new ServicePara() ; 
            try { 
                id_utiliser=ss.returnLast();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLParaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else 
        {
            id_utiliser=id_tab;
        }
        
        System.out.println("l'id finale  ");
        System.out.println(id_utiliser);
        return id_utiliser ;
    }

    @FXML
    private void AjouterPara(ActionEvent event) throws IOException,ParseException {
         ControleSaisie cs = new ControleSaisie() ;
        if (!nomEntry.getText().equals("") && !AdresseEntry.getText().equals("") 
                && !telEntry.getText().equals("") && !EmailEntry.getText().equals("")
                && !heureOuvrEntry.getEditor().getText().equals("") && !heureFermEntry.getEditor().getText().equals("")
                && !id_respEntry.getText().equals(""))
        {
              System.out.println("je suis laaaaaaaaaaa");
               if(cs.GSM(telEntry.getText()))
            {
            if(cs.mailformat(EmailEntry.getText()))
                {
            
             ServicePara sp=new ServicePara();
             DateFormat sdf = new SimpleDateFormat("hh:mm a");
              java.sql.Time timeouv = new java.sql.Time(sdf.parse(heureOuvrEntry.getEditor().getText()).getTime());
             java.sql.Time timeferm = new java.sql.Time(sdf.parse(heureFermEntry.getEditor().getText()).getTime());
            
            if(cs.testTimeOuv_fem(timeouv, timeferm) == -1) {
              
             Parapharmacie p=new Parapharmacie(nomEntry.getText(), Integer.parseInt(AdresseEntry.getText() )
                     ,Integer.parseInt(telEntry.getText()) ,EmailEntry.getText(),
                timeouv,timeferm,Integer.parseInt(id_respEntry.getText()));
       
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
            alert.setHeaderText("done with success");
            Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
                try {
                    sp.AjouterPara(p);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
          
           
           // System.out.println("\n \n c bonnnnnnnnnnn wleeyyyyyyyyyyyy !!! ");
        }
            
        }
            else {
                              Alert alertE = new Alert(Alert.AlertType.CONFIRMATION);
                                            alertE.setTitle("Erreur d'ajout ");
                                            alertE.setHeaderText("temps d'ouverture doit etre inferieur au temps de fermeture ");
                                            Optional<ButtonType> result = alertE.showAndWait();
                        }
                }
              else 
                {
                    Alert alertE = new Alert(Alert.AlertType.CONFIRMATION);
                                        alertE.setTitle("Erreur d'ajout ");
                                        alertE.setHeaderText("Format du mail invalide");
                                        Optional<ButtonType> result = alertE.showAndWait();
                }
        }
        else 
            {
               Alert alertE = new Alert(Alert.AlertType.CONFIRMATION);
                                    alertE.setTitle("Erreur d'ajout ");
                                    alertE.setHeaderText("Numero telephone doit contenir 8 chiffres");
                                    Optional<ButtonType> result = alertE.showAndWait(); 
            }
            
            
        } else 
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur champs vides");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
        }
          
        
        
    }
     private void showDetails() throws ParseException
    {
        ServicePara sp= new ServicePara() ; 
        Parapharmacie p = new Parapharmacie();
        
       
        p=sp.findById(id_par) ;
        //System.out.println(p);
        
        
          
        //hhhhhhhhhhh fih barcha 5orme 7asilo pour que je récupere l valeur ta3 time ml base w n5aliha fi timepicker
        //3h presque 
        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
        
        String timeN = sdf2.format(sdf1.parse(p.getHoraire_ouverture_para().toString()));
        
        
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime time = LocalTime.parse(timeN) ; 
        heureOuvrEntry.setValue(time);
        System.out.println(time);
        
        SimpleDateFormat sdf3 = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat sdf4 = new SimpleDateFormat("hh:mm:ss");
        
        String timeN1 = sdf4.format(sdf3.parse(p.getHoraire_fermeture_para().toString()));
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime time1 = LocalTime.parse(timeN1) ; 
        heureFermEntry.setValue(time1);
        System.out.println(time1);
        nomEntry.setText(p.getNom_para());
        telEntry.setText(Integer.toString(p.getNum_tel_para()));
        EmailEntry.setText(p.getEmail_para());
        id_respEntry.setText(Integer.toString(p.getId_resp_para()));
        AdresseEntry.setText(Integer.toString(p.getAdresse_para()));
        
        

        
    }

    @FXML
    private void AfficherList(ActionEvent event) throws IOException {
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLAfficherListePara.fxml"));
                Parent root;
                root = loader.load();
                FXMLAfficherListeParaController lp=loader.getController();
                nom_p.getScene().setRoot(root);
    }

    @FXML
    private void updatePara(ActionEvent event) throws ParseException {
         DateFormat sdf = new SimpleDateFormat("hh:mm a");
        java.sql.Time timeouv = new java.sql.Time(sdf.parse(heureOuvrEntry.getEditor().getText()).getTime());
        java.sql.Time timeferm = new java.sql.Time(sdf.parse(heureFermEntry.getEditor().getText()).getTime());
       
        ServicePara sp= new ServicePara() ; 
        Parapharmacie p1 = new Parapharmacie();
        try {
            p1=sp.findById(id_par) ;
            p1.setNom_para(nomEntry.getText());
            p1.setAdresse_para(Integer.parseInt(AdresseEntry.getText()));
            p1.setNum_tel_para(Integer.parseInt(telEntry.getText()));
            p1.setEmail_para(EmailEntry.getText());
            p1.setHoraire_ouverture_para(timeouv);
            p1.setHoraire_fermeture_para(timeferm);
           
            ControleSaisie cs = new ControleSaisie() ; 
            if(!nomEntry.getText().equals("") && !AdresseEntry.getText().equals("") && !telEntry.getText().equals("")
                    && !EmailEntry.getText().equals("")
                && !heureOuvrEntry.getEditor().getText().equals("") && !heureFermEntry.getEditor().getText().equals(""))
            {
                if(cs.GSM(telEntry.getText()))
                {
                    if(cs.mailformat(EmailEntry.getText()))
                    {
                        if(cs.testTimeOuv_fem(timeouv, timeferm) == -1)
                        {
                            sp.updatePara(p1, id_par);
                             Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                         alert.setHeaderText("done with success");
                         Optional<ButtonType> result = alert.showAndWait();
                        }
                        else 
                        {
                                             Alert alertE = new Alert(Alert.AlertType.CONFIRMATION);
                                            alertE.setTitle("Erreur d'ajout ");
                                            alertE.setHeaderText("temps d'ouverture doit etre inferieur au temps de fermeture ");
                                            Optional<ButtonType> result = alertE.showAndWait();
                        }
                    }
                    else 
                    {
                        Alert alertE = new Alert(Alert.AlertType.CONFIRMATION);
                                        alertE.setTitle("Erreur d'ajout ");
                                        alertE.setHeaderText("Format du mail invalide");
                                        Optional<ButtonType> result = alertE.showAndWait();
                    }
                } else {
                    Alert alertE = new Alert(Alert.AlertType.CONFIRMATION);
                                    alertE.setTitle("Erreur d'ajout ");
                                    alertE.setHeaderText("Numero telephone doit contenir 8 chiffres");
                                    Optional<ButtonType> result = alertE.showAndWait(); 
                }
            }
            else { 
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ; 
            alert.setTitle("erreur champs vides");
            alert.setHeaderText("il ya des champs vides");
            Optional<ButtonType> result = alert.showAndWait();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLParaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
    
    

