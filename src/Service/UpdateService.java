package Service;

import Entity.IncomeRecord;

public interface UpdateService {
    public void UpdateData(IncomeRecord incomeRecord, double income, String note);
}
