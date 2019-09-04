package Tables;

import javafx.beans.property.*;

public class employees {
    private IntegerProperty empId;
    private StringProperty empName;
    private StringProperty empPhone;
    private StringProperty empAddress;
    private IntegerProperty empExperience;
    private SimpleDoubleProperty empSalary;
  //  private StringProperty empSpecialty;

    public employees() {
        this.empId = new SimpleIntegerProperty();
        this.empName = new SimpleStringProperty();
        this.empPhone = new SimpleStringProperty();
        this.empAddress = new SimpleStringProperty();
        this.empExperience = new SimpleIntegerProperty();
        this.empSalary = new SimpleDoubleProperty();
      //  this.empSpecialty = new SimpleStringProperty();
    }

     public int getEmpId () { return empId.get();}
     public String getEmpName () {return empName.get();}
     public String getEmpPhone () {return empPhone.get();}
     public String getEmpAddress () {return empAddress.get();}
     public int getEmpExperiense () { return empExperience.get();}
     public double getEmpSalary () {return empSalary.get();}
  //   public String getEmpSpecialty () {return empSpecialty.get();}

     public void setEmpId (int empId) {this.empId.set(empId);}
     public void setEmpName (String empName) {this.empName.set(empName);}
     public void setEmpPhone (String empPhone) {this.empPhone.set(empPhone);}
     public void setEmpAddress (String empAddress) {this.empAddress.set(empAddress);}
     public void setEmpExperience (int empExperience) {this.empExperience.set(empExperience);}
     public void setEmpSalary (double empSalary) {this.empSalary.set(empSalary);}
  //   public void setEmpSpecialty(String empSpecialty) {this.empSpecialty.set(empSpecialty);}

    public IntegerProperty empIdProperty() {
        return empId;
    }

    public StringProperty empNameProperty() {
        return empName;
    }

    public StringProperty empPhoneProperty() {
        return empPhone;
    }

    public StringProperty empAddressProperty() {
        return empAddress;
    }

    public IntegerProperty empExperienceProperty() {
        return empExperience;
    }

    public DoubleProperty empSalaryProperty() {
        return empSalary;
    }

  //  public StringProperty empSpecialtyProperty() {
  //      return empSpecialty;
   // }
}
