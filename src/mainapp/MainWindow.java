package mainapp;

import DBUtils.*;
import Tables.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindow {

        @FXML
        private TableColumn<employees, Integer> empId;

        @FXML
        private TableColumn<customer, String> cusName;

        @FXML
        private TableView<customer> customerTable;

        @FXML
        private TableColumn<customer, String> cusCompany;

        @FXML
        private TableColumn<brigades, Integer> brgId;

        @FXML
        private TableView<workpln> planTable;

        @FXML
        private TableColumn<workpln, Integer> plnNo;

        @FXML
        private TableColumn<employees, String> empPhone;

        @FXML
        private TableColumn<employees, String> empSpecialty;

        @FXML
        private TableColumn<customer, Integer> cusId;

        @FXML
        private TableColumn<employees, String> empName;

        @FXML
        private TableColumn<customer, String> cusPhones;

        @FXML
        private TableColumn<objects, String> objTitle;

        @FXML
        private TableColumn<objects, String> objType;

        @FXML
        private TableColumn<brigades, Integer> brgNo;

        @FXML
        private TableColumn<brigades, String> brgEmployee;

        @FXML
        private TableColumn<objects, String> objAddress;

        @FXML
        private TableColumn<objects, String> objCustomer;

        @FXML
        private TableView<employees> employeesTable;

        @FXML
        private TableColumn<workpln, String> plnTitle;

         @FXML
         private TableColumn<workpln, String> plnAddress;

        @FXML
        private TableView<brigades> brigadesTable;

        @FXML
        private TableColumn<workpln, Integer> plnId;

        @FXML
        private TableColumn<workpln, String> plnDate;

        @FXML
        private TableColumn<employees, Double> empSalary;

        @FXML
        private TableView<objects> objectsTable;

        @FXML
        private TableColumn<workpln, String> plnType;

        @FXML
        private TableColumn<employees, Integer> empExp;

        @FXML
        private TableColumn<objects, Integer> objId;

        @FXML
        private TableColumn<employees, String> empAddress;

    @FXML
    private TableView<wrktype> wtypeTable;

    @FXML
    private TableColumn<wrktype, Integer> wtypeId;

    @FXML
    private TableColumn<wrktype, String> wtypeType;

    @FXML
    private TableColumn<wrktype, String> wtypeDescription;

    @FXML
    private TableColumn<wrktype, Double> wtypePrice;

    @FXML
    private TextField cusPhoneField;

    @FXML
    private TextField objCustomerField;

    @FXML
    private TextField brigadeNoField;

    @FXML
    private TextField empPhoneField;

    @FXML
    private TextField objAddressField;

    @FXML
    private TextField wTypeField;

    @FXML
    private TextField empExperienceField;

    @FXML
    private TextField planId;

    @FXML
    private TextField brigadeEmplField;

    @FXML
    private TextField cusNameField;

    @FXML
    private TextField plnTitleField;

    @FXML
    private TextField plnAddressField;

    @FXML
    private TextField cusIdField;

    @FXML
    private TextField objIdField;

    @FXML
    private TextField empAddressField;

    @FXML
    private TextField WTypeField;

    @FXML
    private TextField empIdField;

    @FXML
    private TextField WidField;

    @FXML
    private TextField BrIdField;

    @FXML
    private TextField WDescrField;

    @FXML
    private TextField empSalaryField;

    @FXML
    private TextField objTypeField;

    @FXML
    private TextField plnDateField;

    @FXML
    private TextField objTitleField;

    @FXML
    private TextField plnBrigadeNo;

    @FXML
    private TextField cusCompanyField;

    @FXML
    private TextField empNameField;

    @FXML
    private TextField WPriceField;


    @FXML
    private TableColumn<obj_type, Integer> objTypeId;

    @FXML
    private TableView<obj_type> objTypeTable;

    @FXML
    private TableColumn<obj_type, String> objTypeT;

    @FXML
    private Label dirLabel;


    @FXML
    private void initialize () throws Exception {
        try {
            cusId.setCellValueFactory(cellData -> cellData.getValue().cusIdProperty().asObject());
            cusName.setCellValueFactory(cellData -> cellData.getValue().cusNameProperty());
            cusPhones.setCellValueFactory(cellData -> cellData.getValue().cusPhoneProperty());
            cusCompany.setCellValueFactory(cellData -> cellData.getValue().cusCompanyProperty());
            ObservableList<customer> data = DBLogic.getcustomer();
            populateCustomers(data);
            empId.setCellValueFactory(cellData -> cellData.getValue().empIdProperty().asObject());
            empName.setCellValueFactory(cellData -> cellData.getValue().empNameProperty());
            empPhone.setCellValueFactory(cellData -> cellData.getValue().empPhoneProperty());
            empAddress.setCellValueFactory(cellData -> cellData.getValue().empAddressProperty());
            empExp.setCellValueFactory(cellData -> cellData.getValue().empExperienceProperty().asObject());
            empSalary.setCellValueFactory(cellData -> cellData.getValue().empSalaryProperty().asObject());
           // empSpecialty.setCellValueFactory(cellData -> cellData.getValue().empSpecialtyProperty());
            ObservableList<employees> emplist = DBLogic.getemployee();
            populateEmployee(emplist);
            objId.setCellValueFactory(cellData -> cellData.getValue().objIdProperty().asObject() );
            objTitle.setCellValueFactory(cellData -> cellData.getValue().objTitleProperty());
            objAddress.setCellValueFactory(cellData -> cellData.getValue().objAddressProperty());
            objType.setCellValueFactory(cellData -> cellData.getValue().objTypeProperty());
            objCustomer.setCellValueFactory(cellData -> cellData.getValue().objCustomerProperty());
            ObservableList<objects> objlist = DBLogic.getObjects();
            populateObjects(objlist);
            brgId.setCellValueFactory(cellData -> cellData.getValue().brIdProperty().asObject() );
            brgNo.setCellValueFactory(cellData -> cellData.getValue().brChiefProperty().asObject());
            brgEmployee.setCellValueFactory(cellData -> cellData.getValue().brEmployeeProperty());
            ObservableList<brigades> brlist = DBLogic.getBrigades();
            populateBrigades(brlist);
            plnId.setCellValueFactory(cellData -> cellData.getValue().plnIdProperty().asObject());
            plnTitle.setCellValueFactory(cellData -> cellData.getValue().plnTitleProperty());
            plnAddress.setCellValueFactory(cellData -> cellData.getValue().plnAddressProperty());
            plnNo.setCellValueFactory(cellData -> cellData.getValue().plnBrigadeProperty().asObject());
            plnType.setCellValueFactory(cellData -> cellData.getValue().workTypeProperty());
            plnDate.setCellValueFactory(cellData -> cellData.getValue().plnDateProperty());
            ObservableList<workpln> plnlist = DBLogic.getPln();
            populateWorkpln(plnlist);
            wtypeId.setCellValueFactory(cellData -> cellData.getValue().typeIdProperty().asObject());
            wtypeType.setCellValueFactory(cellData -> cellData.getValue().typeWorkProperty());
            wtypeDescription.setCellValueFactory(cellData -> cellData.getValue().typeDescriptionProperty());
            wtypePrice.setCellValueFactory(cellData -> cellData.getValue().typePriceProperty().asObject());
            ObservableList<wrktype> wktype = DBLogic.getWktype();
            populateWktype(wktype);
            objTypeId.setCellValueFactory(cellData -> cellData.getValue().objtypeIdProperty().asObject());
            objTypeT.setCellValueFactory(cellData -> cellData.getValue().objtypeTProperty());
            ObservableList<obj_type> otype = DBLogic.getObjType();
            populateObjType(otype);

        } catch (SQLException e) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, e);        }
    }

    private void populateCustomers(ObservableList<customer> doclist) {customerTable.setItems(doclist);}
    private void populateEmployee(ObservableList<employees> emplist) {employeesTable.setItems(emplist);}
    private void populateObjects(ObservableList<objects> objlist) {objectsTable.setItems(objlist);}
    private void populateWorkpln(ObservableList<workpln> plnlist) {planTable.setItems(plnlist);}
    private void populateBrigades(ObservableList<brigades> brlist) {brigadesTable.setItems(brlist);}
    private void populateWktype(ObservableList<wrktype> wktype) {wtypeTable.setItems(wktype);}
    private void populateObjType(ObservableList<obj_type> otype) {objTypeTable.setItems(otype);}

    public void onCusEdit() {
        // check the table's selected item and get selected item
        if (customerTable.getSelectionModel().getSelectedItem() != null) {
            customer selectedPerson = customerTable.getSelectionModel().getSelectedItem();
            cusIdField.setText(String.valueOf(selectedPerson.getCusId()));
            cusNameField.setText(selectedPerson.getCusName());
            cusPhoneField.setText(selectedPerson.getCusPhone());
            cusCompanyField.setText(selectedPerson.getCusCompany());
        }}

        public void onEmpEdit() {
            // check the table's selected item and get selected item
            if (employeesTable.getSelectionModel().getSelectedItem() != null) {
                employees selectedPerson = employeesTable.getSelectionModel().getSelectedItem();
                empIdField.setText(String.valueOf(selectedPerson.getEmpId()));
                empNameField.setText(selectedPerson.getEmpName());
                empPhoneField.setText(selectedPerson.getEmpPhone());
                empAddressField.setText(selectedPerson.getEmpAddress());
                empSalaryField.setText(String.valueOf(selectedPerson.getEmpSalary()));
                empExperienceField.setText(String.valueOf(selectedPerson.getEmpExperiense()));
            }  }


    public void onObjEdit() {
        // check the table's selected item and get selected item
        if (objectsTable.getSelectionModel().getSelectedItem() != null) {
            objects selectedPerson = objectsTable.getSelectionModel().getSelectedItem();
            objIdField.setText(String.valueOf(selectedPerson.getObjId()));
            objTitleField.setText(selectedPerson.getObjTitle());
            objAddressField.setText(selectedPerson.getObjAddress());
        }  }

    public void onPlnEdit() {
        // check the table's selected item and get selected item
        if (planTable.getSelectionModel().getSelectedItem() != null) {
            workpln selectedPerson = planTable.getSelectionModel().getSelectedItem();
            planId.setText(String.valueOf(selectedPerson.getplnId()));
            plnTitleField.setText(selectedPerson.getplnTitle());
            plnAddressField.setText(selectedPerson.getplnAddress());
            plnBrigadeNo.setText(String.valueOf(selectedPerson.getplnBrigade()));
            plnDateField.setText(String.valueOf(selectedPerson.getplnBrigade()));
        }  }

    public void onBrigadeEdit() {
        // check the table's selected item and get selected item
        if (brigadesTable.getSelectionModel().getSelectedItem() != null) {
            brigades selectedPerson = brigadesTable.getSelectionModel().getSelectedItem();
            BrIdField.setText(String.valueOf(selectedPerson.getbrId()));
            brigadeNoField.setText(String.valueOf(selectedPerson.getbrChief()));
          //  brigadeEmplField.setText(selectedPerson.getbrEmployee());
        }  }

    public void onTypeEdit() {
        // check the table's selected item and get selected item
        if (wtypeTable.getSelectionModel().getSelectedItem() != null) {
            wrktype selectedPerson = wtypeTable.getSelectionModel().getSelectedItem();
            WidField.setText(String.valueOf(selectedPerson.gettypeId()));
            WTypeField.setText(selectedPerson.gettypeWork());
            WDescrField.setText(selectedPerson.gettypeDescription());
            WPriceField.setText(String.valueOf(selectedPerson.gettypePrice()));
        }  }

    @FXML
    private void insertEmployee(ActionEvent event) throws SQLException {
        String table = "employees";
        String fio = empNameField.getText();
        String phone = empPhoneField.getText();
        String address = empAddressField.getText();
        String exp = empExperienceField.getText();
        String salary = empSalaryField.getText();
        if (fio!= null & phone != null & address != null & exp != null & salary != null) {
            onEmptyAlert(table);
        }
        else {            DBLogic.insertEmployees(fio, phone, address, exp, salary);
            ObservableList<employees> emplist = DBLogic.getemployee();
            populateEmployee(emplist);}
    }

    @FXML
    private void insertCustomer(ActionEvent event) throws SQLException {
        String table = "customer";
        String fio = cusNameField.getText();
        String phone = cusPhoneField.getText();
        String company = cusCompanyField.getText();
        if (fio.isEmpty() | phone.isEmpty() | company.isEmpty()) {
            onEmptyAlert(table);
        }
        else {            DBLogic.insertCustomers(fio, phone, company);
            ObservableList<customer> data = DBLogic.getcustomer();
            populateCustomers(data);}
    }

    @FXML
    private void deleteCustomer(ActionEvent event) throws SQLException {
        String table = "customer";
        int id = Integer.parseInt(cusIdField.getText());
        DBLogic.delete(table , id);
        ObservableList<customer> data = DBLogic.getcustomer();
        populateCustomers(data);
    }

    @FXML
    private void deleteWorktype(ActionEvent event) throws SQLException {
        String table = "work_type";
        int id = Integer.parseInt(WidField.getText());
        DBLogic.delete(table , id);
        ObservableList<wrktype> wktype = DBLogic.getWktype();
        populateWktype(wktype);
    }

    @FXML
    private void updateWorktype(ActionEvent event) throws SQLException {
        String table = "work_type";
        String wtype = WTypeField.getText();
        String wdescr = WDescrField.getText();
        String wprice = WPriceField.getText();
        int id = Integer.parseInt(WidField.getText());
        if (wtype.isEmpty() | wdescr.isEmpty() | wprice.isEmpty() | id ==0) {
            onEmptyAlert(table);
        }
        else {            DBLogic.updateWtype(id, wtype, wdescr, wprice);
            ObservableList<wrktype> wktype = DBLogic.getWktype();
            populateWktype(wktype);}
    }

    @FXML
    private void insertWorktype(ActionEvent event) throws SQLException {
        String table = "work_type";
        String wtype = WTypeField.getText();
        String wdescr = WDescrField.getText();
        String wprice = WPriceField.getText();
        if (wtype !=null & wdescr != null & wprice != null) {
            onEmptyAlert(table);
        }
        else {            DBLogic.insertWtype(wtype, wdescr, wprice);
            ObservableList<wrktype> wktype = DBLogic.getWktype();
            populateWktype(wktype);}
    }

    @FXML
    private void deleteBrigade(ActionEvent event) throws SQLException {
        String table = "brigade";
        int id = Integer.parseInt(BrIdField.getText());
        DBLogic.delete(table , id);
        ObservableList<brigades> brlist = DBLogic.getBrigades();
        populateBrigades(brlist);
    }

    @FXML
    private void updateBrigade(ActionEvent event) throws SQLException {
        String table = "brigade";
        String brno = brigadeNoField.getText();
        String brempl = brigadeEmplField.getText();
        int brid = Integer.parseInt(BrIdField.getText());
        if (brno.isEmpty() | brempl.isEmpty() | brid ==0) {
            onEmptyAlert(table);
        }
        else {            DBLogic.updateBrigade(brid, brno, brempl);
            ObservableList<brigades> brlist = DBLogic.getBrigades();
            populateBrigades(brlist);}
    }

    @FXML
    private void insertBrigade(ActionEvent event) throws SQLException {
        String table = "brigade";
        String brno = brigadeNoField.getText();
         String brempl = brigadeEmplField.getText();
         if (brno.isEmpty() | brempl.isEmpty()) {
             onEmptyAlert(table);
         }
         else {DBLogic.insertBrigade(brno, brempl);
             ObservableList<brigades> brlist = DBLogic.getBrigades();
             populateBrigades(brlist);}
    }
/*
    @FXML
    private void updateWorkpln(ActionEvent event) throws SQLException {
        String table = "work_pln";
        ObservableList<workpln> plnlist = DBLogic.getPln();
        populateWorkpln(plnlist);
    }*/

    @FXML
    private void deleteWorkpln(ActionEvent event) throws SQLException {
        String table = "work_pln";
        int id = Integer.parseInt(planId.getText());
        DBLogic.delete(table , id);
        ObservableList<workpln> plnlist = DBLogic.getPln();
        populateWorkpln(plnlist);
    }

    @FXML
    private void insertWorkpln(ActionEvent event) throws SQLException {
        String table = "work_pln";
        String obj = plnTitleField.getText();
        String brg = plnBrigadeNo.getText();
        String type = wTypeField.getText();
        String date = plnDateField.getText();
        if (obj.isEmpty() | brg.isEmpty() | type.isEmpty() | date.isEmpty()) {
            onEmptyAlert(table);
        }
        else{DBLogic.insertWorkpln(obj, brg, type, date);
            ObservableList<workpln> plnlist = DBLogic.getPln();
            populateWorkpln(plnlist);}
    }

    @FXML
    private void updateCustomer(ActionEvent event) throws SQLException {
        String table = "customer";
        String fio = cusNameField.getText();
        String phone = cusPhoneField.getText();
        String company = cusCompanyField.getText();
        int id = Integer.parseInt(cusIdField.getText());
        if (id==0 | fio.isEmpty() | phone.isEmpty() | company.isEmpty()) {
            onEmptyAlert(table);
        }
        else{DBLogic.updateCustomers(id, fio, phone, company);
            ObservableList<customer> data = DBLogic.getcustomer();
            populateCustomers(data);}
    }

    @FXML
    private void deleteEmployee(ActionEvent event) throws SQLException {
        String table = "employees";
        int id = Integer.parseInt(empIdField.getText());
        DBLogic.delete(table , id);
        ObservableList<employees> emplist = DBLogic.getemployee();
        populateEmployee(emplist);
    }

    @FXML
    private void updateEmployee(ActionEvent event) throws SQLException {
        String table = "employees";
        String fio = empNameField.getText();
        String phone = empPhoneField.getText();
        String address = empAddressField.getText();
        String exp = empExperienceField.getText();
        String salary = empSalaryField.getText();
        String id = empIdField.getText();
        if (id.isEmpty() | fio.isEmpty() & phone.isEmpty() | address.isEmpty() | exp.isEmpty() | salary.isEmpty()){
            onEmptyAlert(table);
        }
        else{DBLogic.updateEmployees(id, fio, phone, address, exp, salary);
            ObservableList<employees> emplist = DBLogic.getemployee();
            populateEmployee(emplist);}
    }

    @FXML
    private void insertObject(ActionEvent event) throws SQLException {
        String table = "objects";
        String title = objTitleField.getText();
        String address = objAddressField.getText();
        String type = objTypeField.getText();
        String customer = objCustomerField.getText();
        if ( title.isEmpty() | address.isEmpty() | type.isEmpty() & customer.isEmpty()) {
            onEmptyAlert(table);
        }
        else{DBLogic.insertObject(type, customer, title, address);
            ObservableList<objects> objlist = DBLogic.getObjects();
            populateObjects(objlist);}
    }

    @FXML
    private void deleteObject(ActionEvent event) throws SQLException {
        String table = "objects";
        int id = Integer.parseInt(objIdField.getText());
        DBLogic.delete(table , id);
        ObservableList<objects> objlist = DBLogic.getObjects();
        populateObjects(objlist);
    }

    @FXML
    private void updateObject(ActionEvent event) throws SQLException {
        String table = "objects";
        String id = objIdField.getText();
        String title = objTitleField.getText();
        String address = objAddressField.getText();
        String type = objTypeField.getText();
        String customer = objCustomerField.getText();
        if (id.isEmpty() | title.isEmpty() | address.isEmpty() | type.isEmpty() | customer.isEmpty()) {
            onEmptyAlert(table);
        }
        else{DBLogic.updateObject(id, type, customer, title, address);
            ObservableList<objects> objlist = DBLogic.getObjects();
            populateObjects(objlist);}
    }

    private void onEmptyAlert(String table) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wrong Data");
        alert.setHeaderText(null);
        alert.setContentText("Wrong input or empty field in table "+table+"");
        alert.showAndWait();    }

    @FXML
    private void exportEmployee(ActionEvent event) throws IOException, SQLException {
        String dir = dirLabel.getText();
        DBLogic.exportEmployee(dir);
    }

    @FXML
    private void choosePath(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Window primaryStage = ((Node) event.getSource()).getScene().getWindow();
        File selectedDirectory =
                directoryChooser.showDialog(primaryStage);

        if(selectedDirectory == null){
            dirLabel.setText("No Directory selected");
        }else{
            dirLabel.setText(selectedDirectory.getAbsolutePath());
        }

    }

    @FXML
    private void exportWtype(ActionEvent event) {
    }

    @FXML
    private void exportWplan(ActionEvent event) {
    }
}