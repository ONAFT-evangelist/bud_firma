package Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class objects {
    private IntegerProperty objId;
    private StringProperty objTitle;
    private StringProperty objAddress;
    private StringProperty objType;
    private StringProperty objCustomer;

    public objects() {
        this.objId = new SimpleIntegerProperty();
        this.objTitle = new SimpleStringProperty();
        this.objAddress = new SimpleStringProperty();
        this.objType = new SimpleStringProperty();
        this.objCustomer = new SimpleStringProperty();
    }

    public int getObjId() {
        return objId.get();
    }

    public String getObjTitle() {
        return objTitle.get();
    }

    public String getObjAddress() {
        return objAddress.get();
    }

    public String getObjType() {
        return objType.get();
    }

    public String getObjCustomer() {
        return objCustomer.get();
    }

    public void setobjId(int objId) {
        this.objId.set(objId);
    }
    public void setobjType(String objType) { this.objType.set(objType);    }
    public void setobjTitle(String objTitle) {
        this.objTitle.set(objTitle);
    }
        public void setobjAddress(String objAddress) { this.objAddress.set(objAddress);    }
    public void setObjCustomer(String objCustomer) {
        this.objCustomer.set(objCustomer);
    }

    public IntegerProperty objIdProperty() {
        return objId;
    }

    public StringProperty objTitleProperty() {
        return objTitle;
    }

    public StringProperty objAddressProperty() {
        return objAddress;
    }

    public StringProperty objTypeProperty() {
        return objType;
    }

    public StringProperty objCustomerProperty() {
        return objCustomer;
    }
}


