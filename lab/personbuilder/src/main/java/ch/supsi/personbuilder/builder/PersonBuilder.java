package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.Person;

public interface PersonBuilder {

    String getFirstname();

    PersonBuilder withFirstname(String firstName);

    String getMiddlename();

    PersonBuilder withMiddlename(String middlename);

    String getLastname();

    PersonBuilder withLastname(String lastname);

    String getEmailAddress();

    PersonBuilder withEmailAddress(String emailAddress);

    String getCellPhoneNumber();

    PersonBuilder withCellPhoneNumber(String cellPhoneNumber);

    PersonBuilder withPerson(Person person);

    Person build() throws InstantiationException;

}
