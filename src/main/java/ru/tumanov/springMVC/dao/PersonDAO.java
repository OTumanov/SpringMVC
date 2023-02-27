package ru.tumanov.springMVC.dao;

import org.springframework.stereotype.Component;
import ru.tumanov.springMVC.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Oleg"));
        people.add(new Person(++PEOPLE_COUNT, "Alex"));
        people.add(new Person(++PEOPLE_COUNT, "Dimon"));
        people.add(new Person(++PEOPLE_COUNT, "Yulya"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people
                .stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }
}
