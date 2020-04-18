package Service.Function;

import Entity.IncomeRecord;
import Entity.UserAccount;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RecordListMaker {
    UserAccount userAccount;
    Calendar calendar = Calendar.getInstance();
    public RecordListMaker(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    public ArrayList<IncomeRecord> getRecordList(int lastDay){
        boolean reachIndex = false;
        ArrayList<IncomeRecord> list = userAccount.getRecordList();
        try {
            calendar.setTime(DateMaker.getDate(DateMaker.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE,lastDay*(-1));
        Date RealDay = calendar.getTime();
        if(userAccount==null)return null;

        ArrayList<IncomeRecord> newList = new ArrayList<>();

        int index = list.size()-lastDay;
        if(index<0){
            index=0;
        }


        for (int i = index;i<list.size();i++){
            if(!reachIndex){
                //获得虚拟开始位标
                Date NowDay = null;
                try {
                    NowDay = DateMaker.getDate(list.get(i).getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(RealDay.getTime()<=NowDay.getTime()){
                    reachIndex = true;
                }
                reachIndex = true;
            }
            if(reachIndex)
                newList.add(list.get(i));
        }
        return newList;
    }
}
