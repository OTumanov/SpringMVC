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

        people.add(new Person(++PEOPLE_COUNT, "Oleg", 21, "asdf@asdf.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Dimon", 22, "mail@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Yulya", 26, "sobaka@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Alex", 77, "mmm_www@bk.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}