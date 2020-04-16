package Service.Function;

import Entity.IncomeRecord;
import Entity.UserAccount;

import java.util.ArrayList;

public class RecordListMaker {
    UserAccount userAccount;

    public RecordListMaker(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    public ArrayList<IncomeRecord> getRecordList(int lastDay){
        ArrayList<IncomeRecord> list = userAccount.getRecordList();
        ArrayList<IncomeRecord> newList = new ArrayList<>();
        for (int i = list.size()-lastDay;i<list.size();i++){
            newList.add(list.get(i));
        }
        return newList;
    }
}
