package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<Car>();
        cars.add(new Car("green", "bmw", 1));
        cars.add(new Car("black", "yota", 2));
        cars.add(new Car("red", "mercedes", 3));
        cars.add(new Car("grey", "tesla", 4));
        cars.add(new Car("purple", "nisan", 5));
    }

    @Override
    public List<Car> index(int i) {
        if (i >= 5) {
            return cars;
        } else if (i < 0) {
            return new ArrayList<Car>();
        } else {
            return cars.stream().limit(i).toList();
        }
    }
}
