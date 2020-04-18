package Entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.*;
import java.util.Date;

public class IncomeRecord implements Serializable {

    private static final long serialVersionUID = 6776189745780254037L;
    transient private SimpleDoubleProperty Income;
    transient private SimpleStringProperty date;
    transient private SimpleStringProperty note;

    public IncomeRecord(double income, String date, String note) {
        Income = new SimpleDoubleProperty(income);

        this.date = new SimpleStringProperty(date);
        this.note = new SimpleStringProperty(note);
    }

    public void setIncome(double income) {
        this.Income.set(income);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public double getIncome() {
        return Income.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getNote() {
        return note.get();
    }
    //自定义序列化处理
    private void writeObject(ObjectOutputStream out) throws IOException {
        double Income = getIncome();
        String date = getDate();
        String note = getNote();
        out.defaultWriteObject();
        out.writeObject(Income);
        out.writeObject(date);
        out.writeObject(note);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        Income = new SimpleDoubleProperty((Double) in.readObject());

        this.date = new SimpleStringProperty((String) in.readObject());
        this.note = new SimpleStringProperty((String) in.readObject());

    }

    @Override
    public String toString() {
        return "IncomeRecord{" +
                "Income=" + Income.get() +
                ", date=" + date.get() +
                ", note='" + note.get() + '\'' +
                '}';
    }

}
