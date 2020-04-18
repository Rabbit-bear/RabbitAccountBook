package Service.Function;

import Entity.IncomeRecord;
import Entity.UserAccount;

import java.util.ArrayList;

public class Calculator {
    private UserAccount userAccount;
    private RecordListMaker recordListMaker;
    private ArrayList<IncomeRecord> list;
    public Calculator(UserAccount userAccount) {
        this.userAccount = userAccount;
        recordListMaker = new RecordListMaker(userAccount);
    }

    public double add(int lastDay){
        double sum = 0 ;
        if(userAccount.getRecordList().size()==0){
            return 0;
        }
        list = recordListMaker.getRecordList(lastDay);
        for (IncomeRecord incomeRecord:list){
            sum += incomeRecord.getIncome();
        }
        return sum;
    }
    public double getCompleteness(IncomeRecord incomeRecord){
        double rate = incomeRecord.getIncome() / userAccount.getTarget();
        return rate;
    }
    public double getCompleteness(){
        double rate = 0;
        double target = userAccount.getTarget();
        list = userAccount.getRecordList();
        if(list.size()==0){
            return  0;
        }
        IncomeRecord incomeRecord = list.get(list.size()-1);
        String Date = incomeRecord.getDate();
        if(Date.equals(DateMaker.getDate())){
            rate = incomeRecord.getIncome()/target;
        }
        return rate;
    }
}
