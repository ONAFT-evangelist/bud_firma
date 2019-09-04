package DBUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import Tables.*;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DBLogic {

    public static ObservableList<obj_type> getObjType() throws SQLException {
        String sql = "select * from obj_type order by id";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<obj_type> typesList  = getTypesObj(rsSet);
            return typesList;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }
    private static ObservableList<obj_type> getTypesObj(ResultSet rsSet) throws SQLException {

        try {
            ObservableList<obj_type> typeslist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                obj_type med = new obj_type();
                med.setobjtypeId(rsSet.getInt("id"));
                med.setobjtypeT(rsSet.getString("title"));
                typeslist.add(med);            }
            return typeslist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    public static ObservableList<customer> getcustomer() throws SQLException {
        String sql = "select * from customer order by id";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<customer> customerList  = getcustomerObj(rsSet);
            return customerList;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }
    private static ObservableList<customer> getcustomerObj(ResultSet rsSet) throws SQLException {

        try {
            ObservableList<customer> customerslist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                customer med = new customer();
                med.setCusId(rsSet.getInt("id"));
                med.setCusName(rsSet.getString("fio"));
                med.setCusPhone(rsSet.getString("phone"));
                med.setCusCompany(rsSet.getString("company"));
                customerslist.add(med);            }
            return customerslist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    public static ObservableList<employees> getemployee() throws SQLException {
        //, specialty.title as "specialty"
        //, work_spc , specialty
        //                 "where work_spc.specialty = specialty.id and employees.id = work_spc.worker\n" +
        String sql = "select employees.id, fio, phone, address, experience, salary::decimal from employees  \n" +
                "order by employees.id";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<employees> employeeList  = getemployeeObj(rsSet);
            return employeeList;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    private static ObservableList<employees> getemployeeObj(ResultSet rsSet) throws SQLException {

        try {
            ObservableList<employees> employeeslist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                employees med = new employees();
                med.setEmpId(rsSet.getInt("id"));
                med.setEmpName(rsSet.getString("fio"));
                med.setEmpPhone(rsSet.getString("phone"));
                med.setEmpAddress(rsSet.getString("address"));
                med.setEmpExperience(rsSet.getInt("experience"));
                med.setEmpSalary(rsSet.getDouble("salary"));
               // med.setEmpSpecialty(rsSet.getString("specialty"));
                employeeslist.add(med);            }
            return employeeslist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    public static ObservableList<objects> getObjects() throws SQLException {
        String sql = "select objects.id , obj_type.title as \"building\" , customer.fio as \"customer\" , address , objects.title as \"type\" from objects , obj_type , customer\n" +
                "                where objects.type = obj_type.id and objects.customer = customer.id\n" +
                "                order by objects.id ";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<objects> objlist  = getObj(rsSet);
            return objlist;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    private static ObservableList<objects> getObj(ResultSet rsSet) throws SQLException {
        try {
            ObservableList<objects> objlist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                objects med = new objects();
                med.setobjId(rsSet.getInt("id"));
                med.setobjType(rsSet.getString("building"));
                med.setobjTitle(rsSet.getString("type"));
                med.setobjAddress(rsSet.getString("address"));
                med.setObjCustomer(rsSet.getString("customer"));
                objlist.add(med);            }
            return objlist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }    }

    public static ObservableList<brigades> getBrigades() throws SQLException {
        String sql = "select distinct list_br.id, team , employees.fio as \"employee\"  from list_br ,employees\n" +
                "where list_br.worker = employees.id order by list_br.id ";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<brigades> brlist  = getBrigade(rsSet);
            return brlist;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    private static ObservableList<brigades> getBrigade(ResultSet rsSet) throws SQLException {
        try {
            ObservableList<brigades> brlist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                brigades med = new brigades();
                med.setbrId(rsSet.getInt("id"));
                med.setbrChief(rsSet.getInt("team"));
                med.setbrEmployee(rsSet.getString("employee"));
                brlist.add(med);            }
            return brlist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }

    }

    public static ObservableList<workpln> getPln() throws SQLException {
        String sql = "select work_pln.id , objects.title, objects.address , brigade as \"brigade_no\" , work_type.kind as \"kind\" , started as \"date started\"\n" +
                "from work_pln , work_type , objects\n" +
                "where work_pln.object = objects.id and work_pln.w_type = work_type.id";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<workpln> brlist  = getPlan(rsSet);
            return brlist;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    private static ObservableList<workpln> getPlan(ResultSet rsSet) throws SQLException {
        try {
            ObservableList<workpln> objlist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                workpln med = new workpln();
                med.setplnId(rsSet.getInt("id"));
                med.setplnTitle(rsSet.getString("title"));
                med.setplnAddress(rsSet.getString("address"));
                med.setPlnBrigade(rsSet.getInt("brigade_no"));
                med.setworkType(rsSet.getString("kind"));
                med.setPlnDate(rsSet.getString("date started"));
                objlist.add(med);            }
            return objlist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }

    }

    public static ObservableList<wrktype> getWktype() throws SQLException {
        String sql = "select work_type.id , work_type.kind , work_type.descr , work_type.price::decimal from work_type order by id";
        try {
            ResultSet rsSet = DBUtils.dbExecute(sql);
            ObservableList<wrktype> wrktypesList  = getWrktypeObj(rsSet);
            return wrktypesList;
        } catch (SQLException ex){
            System.out.println("smth went wrong while load data from table customer"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    private static ObservableList<wrktype> getWrktypeObj(ResultSet rsSet) throws SQLException {

        try {
            ObservableList<wrktype> wrktypeslist = FXCollections.observableArrayList();

            while (rsSet.next()) {
                wrktype med = new wrktype();
                med.settypeId(rsSet.getInt("id"));
                med.settypeWork(rsSet.getString("kind"));
                med.settypeDescription(rsSet.getString("descr"));
                med.settypePrice(rsSet.getDouble("price"));
                wrktypeslist.add(med);            }
            return wrktypeslist;
        } catch (SQLException ex){
            System.out.println("receive data error!!!"+ex);
            ex.printStackTrace();
            throw ex;        }
    }

    public static void delete(String table, int id) throws SQLException {
        String sql = "delete from "+table+" where id="+id;
        DBUtils.dbExecuteQuery(sql);
    }

    public static void insertEmployees(String fio, String phone, String address, String exp, String salary) throws SQLException {
        String sql = "insert into employees values (default, '"+fio+"', '"+phone+"' , '"+address+"' , "+exp+" , "+salary+")";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void updateEmployees(String id, String fio, String phone, String address, String exp, String salary) throws SQLException {
        String sql = "update employees set fio='"+fio+"' , phone='"+phone+"',address='"+address+"',experience="+exp+",salary= "+salary+" where id = "+id+"";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void insertCustomers(String fio, String phone, String company) throws SQLException {
        String sql = "insert into customer values (default, '"+fio+"', '"+phone+"' , '"+company+"' )";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void updateCustomers(int id, String fio, String phone, String company) throws SQLException {
        String sql = "update customer set fio='"+fio+"' , phone='"+phone+"',company='"+company+"' where id = "+id+"";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void insertWtype(String kind, String descr, String price) throws SQLException {
        String sql = "insert into work_type values (default, '"+kind+"', '"+descr+"' , "+price+" )";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void updateWtype(int id, String kind, String descr, String price) throws SQLException {
        String sql = "update work_type set kind='"+kind+"' , descr='"+descr+"',price='"+price+"' where id = "+id+"";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void insertBrigade(String fio, String phone) throws SQLException {
        String sql = "insert into list_br values (default, '"+fio+"', '"+phone+"' )";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void updateBrigade(int id, String fio, String phone) throws SQLException {
        String sql = "update list_br set team='"+fio+"' , worker='"+phone+"' where id = "+id+"";
        DBUtils.dbExecuteQuery(sql);
    }


    public static void insertWorkpln(String obj, String brigade, String type, String date) throws SQLException {
        String sql = "insert into work_pln values (default, "+obj+", "+brigade+" , "+type+" , '"+date+"' )";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void insertObject(String obj, String address, String type, String customer) throws SQLException {
        String sql = "insert into work_pln values (default, "+type+", "+customer+" , '"+obj+"' , '"+address+"' )";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void updateObject(String id, String type, String customer, String title, String address) throws SQLException {
        String sql = "update work_pln set type="+type+", customer="+customer+" , title= '"+title+"' , address= '"+address+"' where id = "+id+"";
        DBUtils.dbExecuteQuery(sql);
    }

    public static void exportEmployee(String dir) throws SQLException, IOException {
        String sql = "select employees.id, fio, phone, address, experience, salary::decimal from employees  \n" +
                "order by employees.id";
        int i = 0;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees");
        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell((short) 0).setCellValue("FIO");
        rowhead.createCell((short) 1).setCellValue("Phone");
        rowhead.createCell((short) 2).setCellValue("Address");
        rowhead.createCell((short) 3).setCellValue("Experience");
        rowhead.createCell((short) 4).setCellValue("Salary");
        ResultSet rs = DBUtils.dbExecute(sql);
        while (rs.next()){
            HSSFRow row = sheet.createRow((short) i);
            row.createCell((short) 0).setCellValue(rs.getString("fio"));
            row.createCell((short) 1).setCellValue(rs.getString("phone"));
            row.createCell((short) 2).setCellValue(rs.getString("address"));
            row.createCell((short) 3).setCellValue(Integer.toString(rs.getInt("experience")));
            row.createCell((short) 4).setCellValue(Double.toString(rs.getDouble("salary")));
            i++;
        }
String file = new StringBuilder().append(dir).append("/Employees.xls").toString();
        FileOutputStream fileOut = new FileOutputStream(file);
        workbook.write(fileOut);
        fileOut.close();
    }
}
