package Service;

import Entity.IncomeRecord;

public interface UpdateService {
    public IncomeRecord UpdateData(int index, double income, String note);
}
