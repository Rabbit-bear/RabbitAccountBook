package Service.Impl;

import Entity.IncomeRecord;
import Entity.UserAccount;
import Service.UpdateService;

import java.util.ArrayList;

public class UpdateServiceImpl implements UpdateService {
    UserAccount userAccount;
    ArrayList<IncomeRecord> list;
    public UpdateServiceImpl(UserAccount userAccount) {
        this.userAccount = userAccount;
        list = userAccount.getRecordList();
    }

    @Override
    public IncomeRecord UpdateData(int index, double income, String note){
        if(list==null&&list.size()==0)return null;
        IncomeRecord incomeRecord = list.get(index);
        if (income!=0){
            //更改总收益
            double temp = income-incomeRecord.getIncome();
            userAccount.setBalance(userAccount.getBalance()+temp);
            incomeRecord.setIncome(income);
        }
        if(note!=null&&note.trim().length()!=0){
            incomeRecord.setNote(note);
        }
        return incomeRecord;
    }


}
