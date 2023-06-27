package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> carList = new ArrayList<>();
    @Override
    public List<Car> getCarsSelected(int amount) {
        setCarList();
        amount = Math.min(Math.max(amount, 0), carList.size());
        return carList.subList(0, amount);
    }

    private void setCarList() {
        carList.clear();
        carList.add(new Car(1, "Nissan", "Note"));
        carList.add(new Car(2, "Nissan", "Qashqai"));
        carList.add(new Car(3, "Subaru", "Forester"));
        carList.add(new Car(4, "Toyota", "Fielder"));
        carList.add(new Car(5, "Honda", "Spike"));
    }
    public CarDaoImpl() {
        setCarList();
    }
}
