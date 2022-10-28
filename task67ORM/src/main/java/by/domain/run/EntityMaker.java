package by.domain.run;

import by.domain.pojo.Book;
import by.domain.pojo.Car;
import by.domain.pojo.SmartWatch;
import by.domain.pojo.addingfield.AddingBook;
import by.domain.pojo.addingfield.AddingCar;
import by.domain.pojo.addingfield.AddingWatch;

import java.util.ArrayList;
import java.util.List;

public class EntityMaker {
    public static List<Car> getCars(int capacity) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(new Car(null,"brand_" + i,"model_" + i,
                    new AddingCar("type_drive_"+i,2,"color_" + i)));
        }
        return list;
    }

    public static List<Book> getBooks(int capacity) {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(new Book(null,"naming_" + i,
                    new AddingBook("writer_"+i,1987+i,"publishing_office_" + i)));
        }
        return list;
    }

    public static List<SmartWatch> getWatches(int capacity) {
        List<SmartWatch> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(new SmartWatch(null,"brand_" + i,"OS_"+i,42,
                    new AddingWatch(128,"Li-ON",2)));
        }
        return list;
    }
}
