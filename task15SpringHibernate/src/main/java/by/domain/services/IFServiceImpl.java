package by.domain.services;

import by.domain.myDao.CarDao;
import by.domain.myModel.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IFServiceImpl implements IFService {

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public void someOperation() {
        Car car = new Car(null,"mercedes",2005,"someColor");
        carDao.create(car);
        Car car1 = carDao.findById(2);
        System.out.println(car1);
        carDao.delete(car1);
        List<Car> carList = carDao.readAll();
        for (Car c : carList) {
            System.out.println(c);
        }
    }
}
