package Entity;

import java.io.Serializable;
import java.util.Date;

public class IncomeRecord implements Serializable {
    private static final long serialVersionUID = 6776189745780254037L;
    double Income;
    String date;
    String note;

    public IncomeRecord(double income, String date, String note) {
        Income = income;
        this.date = date;
        this.note = note;
    }

    public double getIncome() {
        return Income;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public void setIncome(double income) {
        Income = income;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "IncomeRecord{" +
                "Income=" + Income +
                ", date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}
