package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.Person;

abstract public class AbstractPersonBuilder implements PersonBuilder {

    protected String firstname;

    protected String middlename;

    protected String lastname;

    protected String emailAddress;

    protected String cellPhoneNumber;


    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public PersonBuilder withFirstname(String firstName) {
        this.firstname = firstName;
        return this;
    }

    @Override
    public String getMiddlename() {
        return middlename;
    }

    @Override
    public PersonBuilder withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public PersonBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public PersonBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @Override
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    @Override
    public PersonBuilder withCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
        return this;
    }

    @Override
    public PersonBuilder withPerson(Person person) {
        if (person != null) {
            this.firstname = person.getFirstname();
            this.middlename = person.getMiddlename();
            this.lastname = person.getLastname();
            this.emailAddress = person.getEmailAddress();
            this.cellPhoneNumber = person.getCellPhoneNumber();
        }
        
        return this;
    }

}
