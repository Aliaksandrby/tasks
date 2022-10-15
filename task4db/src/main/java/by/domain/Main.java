/*
 * Напишите программу, получающую данные о расходе в качестве исходных
 * параметров main, и добавляющую этот расход в базу, после чего выводящую таблицу
 * расходов на экран (стр. 56)
 */
//TODO: schema and task4db (clean install);

package by.domain;

public class Main {
    public static void main( String[] args ) {
        new TableWritable(args).write();
        new Result().show();
    }
}
