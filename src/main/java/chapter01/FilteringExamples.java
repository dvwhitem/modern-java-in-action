package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class FilteringExamples {

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("red"), new Apple("green"));

      log.info("Apples {}", apples);

    }

    record Apple(String color) {};
    record Apple2(String color) {};
}
