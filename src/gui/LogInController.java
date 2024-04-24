package gui;
import baza.BazaKonekcija;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    @FXML
    private Label logInMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView themeImageView;
    @FXML
    private TextField korisnickoImeLogIn;
    @FXML
    private PasswordField lozinkaLogIn;
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField brojTelefona;
    @FXML
    private TextField jmbg;
    @FXML
    private TextField bankovniRacun;
    @FXML
    private TextField korisnickoImeR;
    @FXML
    private PasswordField lozinkaRegistracija;
    @FXML
    private PasswordField lozinkaPotvrda;
    @FXML
    private Label registrationMessageLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLogIn(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAdmin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File themeFile = new File("Images/palmtrees.jpg");
        Image themeImage = new Image(themeFile.toURI().toString());
        themeImageView.setImage(themeImage);

        File brandingFile = new File("Images/logo.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    public void loginButtonOnAction(ActionEvent event){
        if(korisnickoImeLogIn.getText().isBlank() || lozinkaLogIn.getText().isBlank()){
            logInMessageLabel.setText("Nevažeće korisničko ime ili lozinka");
        }else {

            logInMessageLabel.setText("");
        }
    }
    public void registrationOnAction(ActionEvent event) throws IOException{
        if(ime.getText().isBlank() || prezime.getText().isBlank() ||
                jmbg.getText().isBlank() || bankovniRacun.getText().isBlank() ||
                brojTelefona.getText().isBlank() || korisnickoImeR.getText().isBlank() ||
                lozinkaRegistracija.getText().isBlank() || lozinkaPotvrda.getText().isBlank()){
            registrationMessageLabel.setText("Nedovoljno podataka za prijavu, popunite sva polja");
        }else {
                BazaKonekcija.registerClient(1, ime, prezime, brojTelefona,);
                switchToLogIn(event);
        }
        //to do (uslov za provjeru poklapanja lozinke)
        //da li je zauzeto korisnicko ime
        //i onda tek bez poruke
    }
}