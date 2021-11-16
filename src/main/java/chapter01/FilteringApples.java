package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class FilteringApples {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(220, "red")
        );

        var apple1 = filterApples(inventory, FilteringApples::isHeavyApple);
        log.info("Apple 1: {}", apple1);
        var apple2 = filterApples(inventory, (Apple a) -> "red".equals(a.color()));
        log.info("Apple 2: {}", apple2);
        log.info("----------      Parallel Stream Api    -----------");
        var heavyApple = inventory
                .parallelStream()
                .filter(a -> a.weight() > 200)
                .collect(Collectors.toList());
        log.info("Apple 3 Parallel {}", heavyApple);
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.color());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.weight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        var result = new ArrayList<Apple>();
        for (Apple apple: inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
