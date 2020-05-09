package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.ConcretePerson;

public class OpenMindedPersonBuilder extends AbstractPersonBuilder {

    @Override
    public ConcretePerson build() throws InstantiationException {
        return new ConcretePerson(this);
    }

}
