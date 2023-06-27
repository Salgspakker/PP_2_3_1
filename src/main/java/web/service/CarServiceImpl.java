package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;
    @Override
    public List<Car> getCarsSelected(int amount) {
        return carDao.getCarsSelected(amount);
    }

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }
}
