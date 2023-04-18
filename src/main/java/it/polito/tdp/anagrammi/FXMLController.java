/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tpd.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AnagrammiModel model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAnagrammi"
    private Button btnAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	
    	String input = this.txtInput.getText();
    	
    	if(input.compareTo("")==0) {
    		this.txtCorretti.setText("Inserire una parola per continuare!");
    	}
    	
    	List<String> anagrammi = model.anagrammi(input);
    	
    	for(String s:anagrammi) {
    		if(model.isCorrect(s))
    			this.txtCorretti.appendText(s+"\n");
    		else
    			this.txtErrati.appendText(s+"\n");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtInput.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(AnagrammiModel model) {
   		this.model = model;
   	}

}
