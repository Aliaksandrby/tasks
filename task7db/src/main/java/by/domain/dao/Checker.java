package by.domain.dao;

import java.util.List;

public class Checker {
    public static void checkList(int num, List list,String nameList) {
        if(num < 1 || num > list.size()) {
            System.out.println("no such a number of " + nameList);
            System.exit(1);
        }
    }
}
