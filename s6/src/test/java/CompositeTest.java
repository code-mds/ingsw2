import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeTest {

    @Test
    void printAll() {
        Composite department = new Composite("App Dev");
        department.add(new Person("Valerio", "Mastro", "Project Manager"));

        Composite architects = new Composite("Architecture");
        architects.add(new Person("Paolo", "Ruffo", "Solution Architect"));
        architects.add(new Person("Massimo", "Peri", "SW Architect"));

        Composite qa = new Composite("QA");
        qa.add(new Person("Luca", "Rossi", "Tester"));
        qa.add(new Person("Maria", "Renai", "Tester"));

        department.add(architects);
        department.add(qa);

        department.printAll();
    }
}