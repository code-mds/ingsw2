import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    @Test
    void printAll() {
        Composite dep = new Department("DEPA1");
        dep.add(new Person("Tizio", "Birillo", "CEO"));

        Composite div = new Division("DIVI1");
        dep.add(new Person("Marco", "Branca", "Sicurezza"));

        dep.add(div);
        dep.printAll();
    }
}