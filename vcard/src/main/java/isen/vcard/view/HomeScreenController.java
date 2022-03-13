/**
 * 
 */
package isen.vcard.view;

import java.io.IOException;

import isen.vcard.*;
import javafx.fxml.FXML;


public class HomeScreenController {
	
	@FXML
	public void handleListButton() throws IOException {

		App.showView("VcardList");
	}
	@FXML
	public void handleUpdateButton() throws IOException {
	
		App.showView("VcardUpdate");
	}
	@FXML
	public void handleAddButton() throws IOException {
		
		App.showView("VcardAdd");
	}
	@FXML
	public void handleDeleteButton() throws IOException {	
		App.showView("VcardDelete");
	}
}
