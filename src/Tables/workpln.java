package Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class workpln {
    private IntegerProperty plnId;
    private StringProperty plnTitle;
    private StringProperty plnAddress;
    private StringProperty workType;
    private StringProperty plnKind;
    private IntegerProperty plnBrigade;
    private StringProperty plnDate;

    public workpln() {
        this.plnId = new SimpleIntegerProperty();
        this.plnTitle = new SimpleStringProperty();
        this.plnAddress = new SimpleStringProperty();
        this.workType = new SimpleStringProperty();
        this.plnKind = new SimpleStringProperty();
        this.plnBrigade = new SimpleIntegerProperty();
        this.plnDate = new SimpleStringProperty();
    }

    public int getplnId() {
        return plnId.get();
    }
    public int getplnBrigade () {return plnBrigade.get();}

    public String getplnTitle() {
        return plnTitle.get();
    }

    public String getplnAddress() {
        return plnAddress.get();
    }

    public String getworkType() {
        return workType.get();
    }

    public String plnDate() {
        return plnDate.get();
    }
    public String getplnKind() {
        return plnKind.get();
    }

    public void setplnId(int plnId) {
        this.plnId.set(plnId);
    }

    public void setPlnDate(String plnDate) {this.plnDate.set(plnDate);}

    public void setPlnBrigade(int plnBrigade) {this.plnBrigade.set(plnBrigade);}

    public void setplnTitle(String plnTitle) {
        this.plnTitle.set(plnTitle);
    }

    public void setplnKind(String plnKind) {
        this.plnTitle.set(plnKind);
    }

    public void setplnAddress(String plnAddress) { this.plnAddress.set(plnAddress);    }
    public void setworkType(String workType) { this.workType.set(workType);    }

    public IntegerProperty plnIdProperty() {
        return plnId;
    }

    public StringProperty plnTitleProperty() {
        return plnTitle;
    }

    public StringProperty plnAddressProperty() {
        return plnAddress;
    }

    public StringProperty workTypeProperty() {
        return workType;
    }

    public StringProperty plnKindProperty() {
        return plnKind;
    }

    public IntegerProperty plnBrigadeProperty() {
        return plnBrigade;
    }

    public StringProperty plnDateProperty() {
        return plnDate;
    }
}