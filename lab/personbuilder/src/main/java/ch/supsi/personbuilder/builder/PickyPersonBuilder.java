package ch.supsi.personbuilder.builder;


import ch.supsi.personbuilder.model.ConcretePerson;

public class PickyPersonBuilder extends AbstractPersonBuilder {

    @Override
    public ConcretePerson build() throws InstantiationException {
        if (this.getFirstname() == null || this.getFirstname().isEmpty()) {
            throw new InstantiationException();
        }

        if (this.getLastname() == null || this.getLastname().isEmpty()) {
            throw new InstantiationException();
        }

        return new ConcretePerson(this);
    }

}
