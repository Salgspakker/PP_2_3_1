package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    List<Car> carList = new ArrayList<>();
    @Override
    public List<Car> getCarsSelected(int amount) {
        amount = Math.min(Math.max(amount, 0), carList.size());
        return carList.subList(0, amount);
    }

    public CarServiceImpl() {
        carList.add(new Car(1, "Nissan", "Note"));
        carList.add(new Car(2, "Nissan", "Qashqai"));
        carList.add(new Car(3, "Subaru", "Forester"));
        carList.add(new Car(4, "Toyota", "Fielder"));
        carList.add(new Car(5, "Honda", "Spike"));
    }
}
