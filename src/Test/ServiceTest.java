package Test;

import DAO.Exporter;
import DAO.Importer;
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

public class ServiceTest {
    public static void main(String[] args) {
        Importer importer = new Importer();
        SignUpService signUpService = new SignUpServiceImpl();
        UserAccount userAccount = importer.start();//signUpService.SignUp("txt","admin");
        InsertService insertService = new InsertServiceImpl(userAccount);
        UpdateService updateService = new UpdateServiceImpl(userAccount);
        Exporter exporter = new Exporter();
        DeleteService deleteService = new DeleteServiceImpl(userAccount);
        Calculator calculator = new Calculator(userAccount);
//        insertService.insertData(200,"");
//        insertService.insertData(200,"");
        //updateService.UpdateData(userAccount.getRecordList().get(0),20,"");


//        deleteService.DeleteData(userAccount.getRecordList().get(0));

        //exporter.start(userAccount);
        userAccount.setTarget(500);
        System.out.println(userAccount);
        System.out.println(userAccount.getRecordList());
        System.out.println(calculator.getCompleteness(userAccount.getRecordList().get(1)));
//        System.out.println(userAccount.getBalance());
    }
}