package Service.Impl;

import Entity.IncomeRecord;
import Entity.UserAccount;
import Service.UpdateService;

import java.util.ArrayList;

public class UpdateServiceImpl implements UpdateService {
    UserAccount userAccount;
    public UpdateServiceImpl(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public void UpdateData(IncomeRecord incomeRecord, double income, String note){
        if(incomeRecord==null)return;
        if (income!=0){
            //更改总收益
            double temp = income-incomeRecord.getIncome();
            userAccount.setBalance(userAccount.getBalance()+temp);
            incomeRecord.setIncome(income);
        }
        if(note!=null&&note.trim().length()!=0){
            incomeRecord.setNote(note);
        }





    }


}
