/*
* Составить следующие запросы:
* вывести список получателей платежей, и сумму платежей по каждому из них;
* вывести сумму платежей за тот день, когда был наибольший платеж;
* вывести наибольший платеж за тот день, когда сумма платежа была наибольшей;
*/

//TODO: task6db after task5db (more data);

package by.domain;

public class Main {
    public static void main(String[] args) {

        Requester.generalSqlRequest(Requester.sqlFirst,"receiver", "expense");
        Requester.generalSqlRequest(Requester.sqlSecond,"paydate", "expense");
        Requester.generalSqlRequest(Requester.sqlThird,"paydate", "expense");

        //Requester.first();
        //Requester.second();
        //Requester.third();

    }
}
