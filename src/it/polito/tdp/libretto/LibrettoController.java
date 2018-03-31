/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	Model model;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessagge"
    private TextArea txtMessagge; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice=txtCodice.getText();
    	if(codice.length()<5) {
    		txtMessagge.appendText("Dati esame insuff\n");	
   return;
    }
    	  Esame e= model.trovaEsame(codice);
    	    
    	  if(e==null)
    		  txtMessagge.appendText(codice+ " non trovato\n");
    	  else {
    		  txtMessagge.appendText(codice+ "  trovato\n");
    		  txtCodice.setText(e.getCodice());
    		  txtTitolo.setText(e.getTitolo());
    		  txtDocente.setText(e.getTitolo());
    	  }
    }
    

    @FXML
    void handleInserisci(ActionEvent event) {
    	//recupera dati interfaccia
    	String codice=txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente=txtDocente.getText();
    	
    	//verifica validita dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0) {
    	txtMessagge.appendText("Dati esame insuff\n");	
    		return;
    	}
    	
    	//chiedi a Model di effettuare operazione
    	 Esame e=new Esame(codice,titolo,docente);
    	 boolean result=model.addEsame(e);
    	
    	//aggiorna la vista con il risultato dell operazione
if(result) {
	txtMessagge.appendText("esame aggiunto correttamente\n");
}
else {
	txtMessagge.appendText("esame NON aggiunto (duplicato)\n");
}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessagge != null : "fx:id=\"txtMessagge\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}