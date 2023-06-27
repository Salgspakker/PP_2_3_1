package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarService {
    List<Car> getCarsSelected(int amount);
}
