package ch.supsi;

import ch.supsi.personbuilder.builder.OpenMindedPersonBuilder;
import ch.supsi.personbuilder.builder.PickyPersonBuilder;
import ch.supsi.personbuilder.model.Person;
import ch.supsi.personbuilder.presentation.PersonPresentation;


public class PersonBuilderExample {

    public static void main(String[] args) {
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Person person4 = null;

        // use picky builder
        // build ok
        try {
            person1 = new PickyPersonBuilder()
                    .withFirstname("first name 1")
                    .withMiddlename("middle name 1")
                    .withLastname("last name 1")
                    .withEmailAddress("email@address.1")
                    .build();

            System.out.println(new PersonPresentation(person1).present());

        } catch (InstantiationException ex) {
            System.err.println("person 1...build problem!");
        }

        // use picky builder
        // build fails
        try {
            person2 = new PickyPersonBuilder()
                    .withEmailAddress("email@address.2")
                    .build();

            System.out.println(new PersonPresentation(person2).present());

        } catch (InstantiationException ex) {
            System.err.println("person 2...build problem!");
        }

        // use open builder
        // build ok
        try {
            person3 = new OpenMindedPersonBuilder()
                    .withEmailAddress("email@address.3")
                    .build();

            System.out.println(new PersonPresentation(person3).present());

        } catch (InstantiationException ex) {
            System.err.println("person 3...build problem!");
        }

        // use open builder
        // build ok
        try {
            person4 = new OpenMindedPersonBuilder()
                    .withPerson(person1)
                    .build();

            System.out.println(new PersonPresentation(person4).present());

        } catch (InstantiationException ex) {
            System.err.println("person 4...build problem!");
        }
    }

}
