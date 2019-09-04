package Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Array;

public class customer {
    private IntegerProperty cusId;
    private StringProperty cusName;
    private StringProperty cusPhone;
    private StringProperty cusCompany;

    public customer() {
        this.cusId = new SimpleIntegerProperty();
        this.cusName = new SimpleStringProperty();
        this.cusPhone = new SimpleStringProperty();
        this.cusCompany = new SimpleStringProperty();
    }

    public int getCusId() {
        return cusId.get();
    }

    public String getCusName() {
        return cusName.get();
    }

    public String getCusPhone() {
        return cusPhone.get();
    }

    public String getCusCompany() {
        return cusCompany.get();
    }

    public void setCusId(int cusId) {
        this.cusId.set(cusId);
    }

    public void setCusName(String cusName) {
        this.cusName.set(String.valueOf(cusName));
    }

   public void setCusPhone(String cusPhone) { this.cusPhone.set(String.valueOf(cusPhone));    }
    public void setCusCompany(String cusCompany) { this.cusCompany.set(cusCompany);    }

    public IntegerProperty cusIdProperty() {
        return cusId;
    }

    public StringProperty cusNameProperty() {
        return cusName;
    }

    public StringProperty cusPhoneProperty() {
        return cusPhone;
    }

    public StringProperty cusCompanyProperty() {
        return cusCompany;
    }
}
