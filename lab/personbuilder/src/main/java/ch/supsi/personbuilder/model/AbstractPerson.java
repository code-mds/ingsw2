package ch.supsi.personbuilder.model;

import ch.supsi.personbuilder.builder.PersonBuilder;

abstract public class AbstractPerson implements Person {

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
    public String getMiddlename() {
        return middlename;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public AbstractPerson(PersonBuilder builder) throws InstantiationException {
        if (builder == null) {
            throw new InstantiationException();
        }

        this.firstname = builder.getFirstname();
        this.middlename = builder.getMiddlename();
        this.lastname = builder.getLastname();
        this.emailAddress = builder.getEmailAddress();
        this.cellPhoneNumber = builder.getCellPhoneNumber();
    }

}
