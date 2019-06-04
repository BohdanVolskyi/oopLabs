package lab08.model;

//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Route {


	private final StringProperty name;
    private final StringProperty departure;
    private final StringProperty arrival;
    private final StringProperty placeFree;
    private final StringProperty day;
    private final StringProperty number;
    
    public Route() {
    	this(null, null);
    }
    
    public Route(String name, String number) {
    	this.name = new SimpleStringProperty(name);
    	this.number = new SimpleStringProperty(number);
    	
    	this.placeFree = new SimpleStringProperty();
    	this.departure = new SimpleStringProperty();
    	this.arrival = new SimpleStringProperty();
    	this.day = new SimpleStringProperty();
    }
    
	public String getNazva() {
		return name.get();
	}

	public String getChasPr() {
		return departure.get();
	}

	public String getChasVd() {
		return arrival.get();
	}
	
	public String getPlaceFree() {
		return placeFree.get();
	}
	
	public String getDay() {
		return day.get();
	}

	public String getNomer() {
		return number.get();
	}
	
	public void setNazva(String name) {
		this.name.set(name);
	}

	public void setChasPr(String departure) {
		this.departure.set(departure);
	}

	public void setChasVd(String arrival) {
		this.arrival.set(arrival);
	}
	
	public void setPlaceFree(String placeFree) {
		this.placeFree.set(placeFree);
	}

	public void setDay(String day) {
		this.day.set(day);
	}

	public void setNomer(String number) {
		this.number.set(number);
	}
	
	public StringProperty nazvaProperty() {
		return name;
	}
    
	public StringProperty chasPrProperty() {
		return departure;
	}
	
	public StringProperty chasVdProperty() {
		return arrival;
	}
	
	public StringProperty placeFreeProperty() {
		return placeFree;
	}
	
	public StringProperty dayProperty() {
		return day;
	}
	
	public StringProperty nomerProperty() {
		return number;
	}
}
