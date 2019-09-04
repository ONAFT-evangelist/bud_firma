package Tables;

import javafx.beans.property.*;

public class obj_type {
    private IntegerProperty objtypeId;
    private StringProperty objtypeT;

    public obj_type() {
        this.objtypeId = new SimpleIntegerProperty();
        this.objtypeT = new SimpleStringProperty();
    }

    public int getobjtypeId() {
        return objtypeId.get();
    }

    public String getobjtypeT() {
        return objtypeT.get();
    }

    public void setobjtypeId(int objtypeId) {
        this.objtypeId.set(objtypeId);
    }

    public void setobjtypeT(String objtypeT) {
        this.objtypeT.set(String.valueOf(objtypeT));
    }

    public IntegerProperty objtypeIdProperty() {
        return objtypeId;
    }

    public StringProperty objtypeTProperty() {
        return objtypeT;
    }
}
