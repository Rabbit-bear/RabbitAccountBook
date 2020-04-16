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
}
