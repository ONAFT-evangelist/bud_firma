package Tables;

import javafx.beans.property.*;

public class wrktype {
    private IntegerProperty typeId;
    private StringProperty typeWork;
    private StringProperty typeDescription;
    private SimpleDoubleProperty typePrice;

    public wrktype() {
        this.typeId = new SimpleIntegerProperty();
        this.typeWork = new SimpleStringProperty();
        this.typeDescription = new SimpleStringProperty();
        this.typePrice = new SimpleDoubleProperty();
    }

    public int gettypeId() {
        return typeId.get();
    }

    public String gettypeWork() {
        return typeWork.get();
    }

    public String gettypeDescription() {
        return typeDescription.get();
    }

    public double gettypePrice() {
        return typePrice.get();
    }

    public void settypeId(int typeId) {
        this.typeId.set(typeId);
    }

    public void settypeWork(String typeWork) {
        this.typeWork.set(String.valueOf(typeWork));
    }

    public void settypeDescription(String typeDescription) { this.typeDescription.set(String.valueOf(typeDescription));    }
    public void settypePrice(double typePrice) { this.typePrice.set(typePrice);    }

    public IntegerProperty typeIdProperty() {
        return typeId;
    }

    public StringProperty typeWorkProperty() {
        return typeWork;
    }

    public StringProperty typeDescriptionProperty() {
        return typeDescription;
    }

    public SimpleDoubleProperty typePriceProperty() {
        return typePrice;
    }
}
