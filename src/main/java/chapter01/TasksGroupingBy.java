package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class TasksGroupingBy {
    public static void main(String[] args) {

        var frameworks = List.of(
                new Framework("CodeIgniter", new Language("PHP")),
                new Framework("Kohana", new Language("PHP")),
                new Framework("Yii", new Language("PHP")),
                new Framework("Laravel", new Language("PHP")),
                new Framework("Ruby on Rails", new Language("Ruby")),
                new Framework("Django", new Language("Python")),
                new Framework("Spring", new Language("Spring")),
                new Framework("Spring", new Language("Struts")),
                new Framework("React", new Language("Javascript")),
                new Framework("Vue", new Language("Javascript")),
                new Framework("Angular", new Language("Javascript"))
        );
        var languages = List.of("PHP", "Ruby", "Python", "Java", "Javascript");


        Map<Language, List<Framework>> groupingByLanguage =
                frameworks.stream().filter(l -> l.language.name.equals("PHP"))
                .collect(Collectors.groupingBy(Framework::language));

        log.info("Language {}: ", groupingByLanguage);

    }

    record Framework(String name,  Language language) {};
    record Language(String name) {};

}
