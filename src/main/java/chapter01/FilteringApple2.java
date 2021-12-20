package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class FilteringApple2 {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        var apples = filteringApple(inventory, (Apple apple) -> "red".equalsIgnoreCase(apple.color()));
        log.info("Apples {}", apples);
    }


    private static List<Apple> filteringApple(List<Apple> list, Predicate<Apple> predicate) {
        var apples = new ArrayList<Apple>();
        for(Apple apple: list) {
            if(predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }
}
