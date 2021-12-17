package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class FilteringCar {

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("CLS 200", "Mercedes"),
                new Car("X6", "BMW")
        );

        List<Car> filterCar = filteringCar(cars, FilteringCar::isMercedes);
        log.info("Car {}", filterCar);
    }

    public static List<Car> filteringCar(List<Car> cars, Predicate<Car> p) {
        return cars.stream().filter(car ->  p.test(car)).collect(Collectors.toList());
    }

    public static boolean isBMW(Car car) {
        return car.manufacturer().equalsIgnoreCase("bmw");
    }
    public static boolean isMercedes(Car car) {
        return car.manufacturer().equalsIgnoreCase("mercedes");
    }
}

record Car(String model, String manufacturer) {};
