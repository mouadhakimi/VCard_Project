package isen.vcard.view;

import isen.vcard.*;
import javafx.application.Platform;

public class MainLayoutController {

	public void closeApplication() {
		Platform.exit();
	}

	public void gotoHome() {
		App.showView("HomeScreen");
	}

	public void gotoQuestionAdmin() {
		App.showView("QuestionsAdmin");

	}

}
