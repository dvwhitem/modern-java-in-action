package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class ProgrammingLanguages {

    public static void main(String[] args) {
        List<Languages> languages = Arrays.asList(
                new Languages("PHP", Arrays.asList(
                        new Framework("Simfony"),
                        new Framework("Laravel")
                )
                ), new Languages("JAVA", Arrays.asList(
                        new Framework("Spring Boot"))));

        List<Languages> list = filtering(languages, (Languages l) -> l.frameworks.size() == 1);
        log.info("Size: {}", list);
    }


    private static List<Languages> filtering(List<Languages> list, Predicate<Languages> predicate) {
        return list
                .stream()
                .filter(languages -> predicate.test(languages))
                .collect(Collectors.toList());
    }

    record Languages(String name, List<Framework> frameworks) {};
    record Framework(String name) {};
}

