/*
* измените предыдущую задачу таким образом, что бы она использовала прекомпилированные запросы.
*/
//TODO: task5db (clean install) after task4db; добавляем данные в уже созданные таблицы в task4db;

package by.domain;

public class Main {
    public static void main(String[] args) {
        new TableWritablePrepared(args).write();
        new ResultPrepared().show();
    }
}