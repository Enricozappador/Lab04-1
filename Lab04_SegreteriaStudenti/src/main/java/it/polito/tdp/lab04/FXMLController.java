package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class FXMLController {
	private Model model = new Model(); 
	private ObservableList<Corso> corsi = FXCollections.observableArrayList(); 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> CorsoCombo;

    @FXML
    private Button CercaIscrittibtn;

    @FXML
    private TextField Matricolatxt;

    @FXML
    private CheckBox Autofillbtn;

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
    void handleAutofill(MouseEvent event) {
    	
    	
    	int m ; 
    	
    	Nometxt.clear();
    	Cognometxt.clear();
    	Resulttxt.clear();
    	String s = Matricolatxt.getText();
   
    	
    	
     
    	
    	if(Matricolatxt.getText().isEmpty()) {
    		Resulttxt.appendText("Devi inserire un numero di matricola!");
    		return; 
    	}
    	
    	try {
           m = Integer.parseInt(s); 
        	} catch (NumberFormatException e) {
        		Resulttxt.appendText("Puoi inserire solo numeri");
        		return; 
        	}
    
   Studente stemp = model.AutofillStudenti(m); 
    	
    	
    	if(stemp == null) {
    		Resulttxt.appendText("nessuno studente trovato");
    		return; 
    	}
    String nome = stemp.getNome();
    	String Cognome = stemp.getCognome();
    	Nometxt.appendText(nome);
    	Cognometxt.appendText(Cognome);
    	
    	
    	
    	
    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {
    	List<Corso> result = new ArrayList<>();
    	int m ; 
    	
    	Nometxt.clear();
    	Cognometxt.clear();
    	Resulttxt.clear();
    	String s = Matricolatxt.getText();
   
    	
    	
     
    	
    	if(Matricolatxt.getText().isEmpty()) {
    		Resulttxt.appendText("Devi inserire un numero di matricola!");
    		return;
    	}
    	
    	try {
           m = Integer.parseInt(s); 
        	} catch (NumberFormatException e) {
        		Resulttxt.appendText("Puoi inserire solo numeri");
        		return; 
        	}
    	
    	result.addAll(model.CercaCorsiStudente(m));
    	
    	
    	
    	for(Corso c : result) {
    		Resulttxt.appendText(c.getNomecorso()+"\n");
    	}
    	
    	
    }

    @FXML
    void handleCercaIscritti(ActionEvent event) {
    	
    	Resulttxt.clear();
    	List<Studente> result = new ArrayList<>();
    	Corso c = new Corso(null);
    	if(CorsoCombo.getValue()==null) {
    		Resulttxt.appendText("Devi selezionare un corso");
    	}
    	
    	else {
    		
    		 
    		try {
    	     c = CorsoCombo.getValue();
    	    	} catch (NumberFormatException e) {
    	    		Resulttxt.appendText("Devi Selezionare un corso");
    	    		return; 
    	    	}
    		
    		result = model.getCorso(c); 
    		
    		for (Studente s : result) {
    			Resulttxt.appendText(s.toString());
    		}
    	}

    }

    @FXML
    void handleComboCorsi(ActionEvent event) {

    }

    @FXML
    void handleIscrivi(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {
    	Matricolatxt.clear();
    	Nometxt.clear();
    	Cognometxt.clear();
    	Resulttxt.clear();
    	Autofillbtn.setSelected(false);
    	CorsoCombo.setValue(null);
//    	CorsoCombo.setPromptText("Corso");

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
        
        for (Corso c : model.getTuttiICorsi()) {
        	corsi.add(c); 
        }
        Corso c = new Corso("");
        
        corsi.add(c);
        
        CorsoCombo.setItems(corsi);

    }
}
