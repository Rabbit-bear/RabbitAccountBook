package Test;

import java.util.ArrayList;

public class DAOTest01 {
    ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        DAOTest01 daoTest01 = new DAOTest01();
        daoTest01.Add(daoTest01.list);
        System.out.println(daoTest01.list);
    }
    void Add(ArrayList<Integer> list){
        list.add(1);
    }
}
