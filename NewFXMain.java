/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewFXMain extends Application {

    static Stage stage;
      private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();

    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stg) throws Exception {
        window = stg;
        Parent root = FXMLLoader.load(getClass().getResource("loadingscreen.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
       
        Scene scene = new Scene(root);
 //stg.initStyle(StageStyle.UNDECORATED);

        stg.setScene(scene);
        //stage.setResizable(false);
        stg.show();

    }

//    public static void changescenes(String sceneName) {
//
//        try {
//            Parent root = FXMLLoader.load(NewFXMain.class.getResource(sceneName));
//        
//                       
//
//            stage.setScene(new Scene(root, 650, 500));
//        } catch (IOException ex) {
//            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
   
    
    }

