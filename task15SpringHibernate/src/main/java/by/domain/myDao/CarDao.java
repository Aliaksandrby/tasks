package by.domain.myDao;

import by.domain.myModel.Car;

import java.util.List;

public interface CarDao {
    void create(Car car);
    Car findById(int id);
    List<Car> readAll();
    void delete(Car car);
}
