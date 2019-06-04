package lab08.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab08.model.Route;



public class RouteEditDialogController {

	@FXML
	private TextField nameField;
	@FXML
	private TextField chasPrField;
	@FXML
	private TextField chasVdField;
	@FXML
	private TextField freePlaceField;
	@FXML
	private TextField dayField;
	@FXML
	private TextField nomerField;

	private Stage dialogStage;
	private Route route;
	private boolean okClicked = false;


	@FXML
	private void initialize() {
	}


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}


	public void setRoute(Route route) {
		this.route = route;

		nameField.setText(route.getNazva());
		chasPrField.setText(route.getChasPr());
		chasVdField.setText(route.getChasVd());
		freePlaceField.setText(route.getPlaceFree());
		dayField.setText(route.getDay());
		nomerField.setText(route.getNomer());

	}


	public boolean isOkClicked() {
		return okClicked;
	}


	@FXML
	private void handleOk() {
		if (isInputValid()) {
			route.setNazva(nameField.getText());
			route.setChasPr(chasPrField.getText());
			route.setChasVd(chasVdField.getText());
			route.setPlaceFree(freePlaceField.getText());
			route.setDay(dayField.getText());
			route.setNomer(nomerField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}


	@FXML
	private void handleCancel() {
		dialogStage.close();
	}


	private boolean isInputValid() {
		String errorMessage = "";

		if (nameField.getText() == null || nameField.getText().length() == 0) {
			errorMessage += "No valid name!\n";
		}
		if (chasPrField.getText() == null || chasPrField.getText().length() == 0) {
			errorMessage += "No valid time!\n";
		}
		if (chasVdField.getText() == null || chasVdField.getText().length() == 0) {
			errorMessage += "No valid time!\n";
		}

		if (freePlaceField.getText() == null || freePlaceField.getText().length() == 0) {
			errorMessage += "No valid number of places!\n";
		} 
		if (dayField.getText() == null || dayField.getText().length() == 0) {
			errorMessage += "No valid day!\n";
		}

		if (nomerField.getText() == null || nomerField.getText().length() == 0) {
			errorMessage += "No valid number!\n";
		} 

		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}