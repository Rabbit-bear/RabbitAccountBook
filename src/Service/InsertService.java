package Service;

import Entity.IncomeRecord;
import Entity.UserAccount;

public interface InsertService {
    public IncomeRecord insertData(double Income, String note);
    public IncomeRecord insertData(String date, double Income, String note);
}
