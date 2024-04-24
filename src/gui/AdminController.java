package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private BorderPane borderPane;

    private Label listaRezervacijaLbl;
    public void switchToLogIn(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
   private void switchToDodajAdmina(ActionEvent event) throws IOException{
       AnchorPane view = FXMLLoader.load(getClass().getResource("admin_dodaj.fxml"));
       borderPane.setCenter(view);
   }
   @FXML
    private void switchToRezervacije(ActionEvent event) throws IOException{
        AnchorPane view = FXMLLoader.load(getClass().getResource("rezervacije.fxml"));
        borderPane.setCenter(view);
    }
    @FXML
    private void switchToDodajIzlet(ActionEvent event) throws IOException{
        AnchorPane view = FXMLLoader.load(getClass().getResource("dodaj_izlet.fxml"));
        borderPane.setCenter(view);
    }
    public void switchToAdminPocetak(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void switchToDodajPutovanje(ActionEvent event) throws IOException{
        AnchorPane view = FXMLLoader.load(getClass().getResource("dodaj_putovanje.fxml"));
        borderPane.setCenter(view);
    }

}
