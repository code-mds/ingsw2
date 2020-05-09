package ch.supsi.personbuilder.model;


import ch.supsi.personbuilder.builder.PersonBuilder;

public class ConcretePerson extends AbstractPerson {

    public ConcretePerson(PersonBuilder builder) throws InstantiationException {
        super(builder);
    }

}
