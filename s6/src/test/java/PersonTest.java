class PersonTest {

    @org.junit.jupiter.api.Test
    void printAll() {
        Component c = new Person("Massimo", "De Santi", "Architect");
        c.printAll();
    }
}