/*
 * Задание 6:
 * Создайте разные сущности в вашем приложении, каждая из которых использовала
 * разный генератор идентификаторов. Извлеките идентификаторы из Persistent объектов
 * и выведите их на консоль. (стр 119)
 *
 * Задание 7:
 * Добавьте к существующим сущностям дополнительные поля (например: адрес,
 * город, почтовый код) и вынесите эту информацию в отдельный класс. Настройте
 * отображение, и запустите приложение. Опишите ваши проблемы, возникшие в процессе
 * работы. (стр 121)
 */

package by.domain.run;

import by.domain.pojo.Book;
import by.domain.pojo.Car;
import by.domain.pojo.SmartWatch;

public class App {
    public static void main(String[] args) {

        AggregateTable<Car> tableCar = new AggregateTable<>();
        tableCar.fill(EntityMaker.getCars(10));

        AggregateTable<Book> tableBook = new AggregateTable<>();
        tableBook.fill(EntityMaker.getBooks(10));

        AggregateTable<SmartWatch> tableWatch = new AggregateTable<>();
        tableWatch.fill(EntityMaker.getWatches(10));

        GenericViewer<Car> carGenericViewer = new GenericViewer<>();
        carGenericViewer.genericShow("from Car");

        GenericViewer<Book> bookGenericViewer = new GenericViewer<>();
        bookGenericViewer.genericShow("from Book");

        GenericViewer<SmartWatch> watchGenericViewer = new GenericViewer<>();
        watchGenericViewer.genericShow("from Watch");
    }
}
