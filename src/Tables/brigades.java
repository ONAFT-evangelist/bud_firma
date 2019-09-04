package Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class brigades {
    private IntegerProperty brId;
    private IntegerProperty brChief;
    private StringProperty brEmployee;

    public brigades() {
        this.brId = new SimpleIntegerProperty();
        this.brChief = new SimpleIntegerProperty();
        this.brEmployee = new SimpleStringProperty();
    }

    public int getbrId() {
        return brId.get();
    }

    public int getbrChief() {
        return brChief.get();
    }

    public String getbrEmployee() {
        return brEmployee.get();
    }


    public void setbrId(int brId) {
        this.brId.set(brId);
    }

    public void setbrChief(int brChief) {
        this.brChief.set(brChief);
    }

    public void setbrEmployee(String brEmployee) { this.brEmployee.set(brEmployee);    }

    public IntegerProperty brIdProperty() {
        return brId;
    }

    public IntegerProperty brChiefProperty() {
        return brChief;
    }

    public StringProperty brEmployeeProperty() {
        return brEmployee;
    }
}

