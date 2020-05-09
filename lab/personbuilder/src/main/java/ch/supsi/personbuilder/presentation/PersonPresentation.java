package ch.supsi.personbuilder.presentation;


import ch.supsi.personbuilder.model.Person;

public class PersonPresentation extends AbstractPresentation {

    protected Person person;

    public PersonPresentation(Person person) throws InstantiationException {
        if (person == null) {
            throw new InstantiationException();
        }

        this.person = person;
    }

    @Override
    public String present() {
        String presentation = "PERSON PRESENTATION...";

        if (person.getFirstname() != null && !person.getFirstname().isEmpty()) {
            presentation += "\n" + "first name..." + person.getFirstname();
        }

        if (person.getMiddlename() != null && !person.getMiddlename().isEmpty()) {
            presentation += "\n" + "middle name..." + person.getMiddlename();
        }

        if (person.getLastname() != null && !person.getLastname().isEmpty()) {
            presentation += "\n" + "last name..." + person.getLastname();
        }

        if (person.getEmailAddress() != null && !person.getEmailAddress().isEmpty()) {
            presentation += "\n" + "email address..." + person.getEmailAddress();
        }

        if (person.getCellPhoneNumber() != null && !person.getCellPhoneNumber().isEmpty()) {
            presentation += "\n" + "cell phone number..." + person.getCellPhoneNumber();
        }

        return presentation;
    }

}
