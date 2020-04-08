package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> CorsoCombo;

    @FXML
    private Button CercaIscrittibtn;

    @FXML
    private TextField Matricolatxt;

    @FXML
    private RadioButton Autofillbtn;

    @FXML
    private TextField Nometxt;

    @FXML
    private TextField Cognometxt;

    @FXML
    private Button CercaCorsibtn;

    @FXML
    private Button Iscrivibtn;

    @FXML
    private TextArea Resulttxt;

    @FXML
    private Button Resetbtn;

    @FXML
    void handleAutofill(ActionEvent event) {

    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {

    }

    @FXML
    void handleCercaIscritti(ActionEvent event) {

    }

    @FXML
    void handleComboCorsi(ActionEvent event) {

    }

    @FXML
    void handleIscrivi(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert CorsoCombo != null : "fx:id=\"CorsoCombo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CercaIscrittibtn != null : "fx:id=\"CercaIscrittibtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Matricolatxt != null : "fx:id=\"Matricolatxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Autofillbtn != null : "fx:id=\"Autofillbtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Nometxt != null : "fx:id=\"Nometxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Cognometxt != null : "fx:id=\"Cognometxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CercaCorsibtn != null : "fx:id=\"CercaCorsibtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Iscrivibtn != null : "fx:id=\"Iscrivibtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Resulttxt != null : "fx:id=\"Resulttxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Resetbtn != null : "fx:id=\"Resetbtn\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
