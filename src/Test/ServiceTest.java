package Test;

import DAO.Exporter;
import DAO.Importer;
import Entity.IncomeRecord;
import Entity.UserAccount;
import Service.DeleteService;
import Service.Function.Calculator;
import Service.Impl.DeleteServiceImpl;
import Service.Impl.InsertServiceImpl;
import Service.Impl.SignUpServiceImpl;
import Service.Impl.UpdateServiceImpl;
import Service.InsertService;
import Service.SignUpService;
import Service.UpdateService;
import javafx.beans.property.SimpleStringProperty;

public class ServiceTest {
    public static void main(String[] args) {
        Importer importer = new Importer();
        SignUpService signUpService = new SignUpServiceImpl();
        UserAccount userAccount = importer.start();//signUpService.SignUp("txt","admin");//
        InsertService insertService = new InsertServiceImpl(userAccount);
        UpdateService updateService = new UpdateServiceImpl(userAccount);
        Exporter exporter = new Exporter();
        DeleteService deleteService = new DeleteServiceImpl(userAccount);
        Calculator calculator = new Calculator(userAccount);
//        insertService.insertData(200,"");
//        insertService.insertData(200,"");
        //updateService.UpdateData(userAccount.getRecordList().get(0),20,"");
//        deleteService.DeleteData(userAccount.getRecordList().get(0));
        userAccount.setBalance(0);
        insertService.insertData("2020-04-13", 400, "");
        insertService.insertData("2020-04-14", 400, "");
        insertService.insertData("2020-04-15", 400, "");
        insertService.insertData("2020-04-16", 400, "");
        insertService.insertData("2020-04-17", 400, "");


        exporter.start(userAccount);

        System.out.println(userAccount);
////        System.out.println(calculator.add(1));
        System.out.println(userAccount.getRecordList());
//        System.out.println(calculator.getCompleteness(userAccount.getRecordList().get(1)));
//        System.out.println(userAccount.getBalance());
    }
}