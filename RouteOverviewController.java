package lab08.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lab08.MainApp;
import lab08.model.Route;

public class RouteOverviewController {
	
		
    	@FXML
    	private TableView<Route> routeTable;
	 	
	    @FXML
	    private TableColumn<Route, String> firstNameColumn;
	    @FXML
	    private TableColumn<Route, String> lastNameColumn;
	    
	//Ticket

	    @FXML
	    private Label nazvaLabel;
	    @FXML
	    private Label chasPrLabel;
	    @FXML
	    private Label chasVdLabel;
	    @FXML
	    private Label placeFreeLabel;
	    @FXML
	    private Label dayLabel;
	    @FXML
	    private Label nomerLabel;

	    private MainApp mainApp;


	    public RouteOverviewController() {
	    }


	    @FXML
	    private void initialize() {
	        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nazvaProperty());
	        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().nomerProperty());
	        
	        showRouteDetails(null);
	        
	        routeTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showRouteDetails(newValue));
	    }


	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;

	        routeTable.setItems(mainApp.getPersonData());
	    }
	    
	   
	    private void showRouteDetails(Route route) {
	        if (route != null) {
	            nazvaLabel.setText(route.getNazva());
	            chasPrLabel.setText(route.getChasPr());
	            chasVdLabel.setText(route.getChasVd());
	            placeFreeLabel.setText(route.getPlaceFree());
	            dayLabel.setText(route.getDay());
	            nomerLabel.setText(route.getNomer());
	        } else {
	            nazvaLabel.setText("");
	            chasPrLabel.setText("");
	            chasVdLabel.setText("");
	            placeFreeLabel.setText("");
	            dayLabel.setText("");
	            nomerLabel.setText("");
	        }
	    }
	    
	    @FXML
	    private void handleDeleteRoute() {
	        int selectedIndex = routeTable.getSelectionModel().getSelectedIndex();
	        if(selectedIndex>=0) {
	        routeTable.getItems().remove(selectedIndex);
	        }
	        else {
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Person Selected");
	            alert.setContentText("Please select a person in the table.");

	            alert.showAndWait();
	        }
	    }
	    
	    @FXML
	    private void handleNewPerson() {
	    	Route tempPerson = new Route();
	        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
	        if (okClicked) {
	            mainApp.getPersonData().add(tempPerson);
	        }
	    }

	    @FXML
	    private void handleEditPerson() {
	        Route selectedPerson = routeTable.getSelectionModel().getSelectedItem();
	        if (selectedPerson != null) {
	            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
	            if (okClicked) {
	                showRouteDetails(selectedPerson);
	            }

	        } else {
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Person Selected");
	            alert.setContentText("Please select a person in the table.");

	            alert.showAndWait();
	        }
	    }
}
