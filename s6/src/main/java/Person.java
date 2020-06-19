public class Person implements Component {
    private final String name;
    private final String surname;
    private final String role;

    public Person(String name, String surname, String role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public void printAll() {
        System.out.println(String.format("Name[%s] Surname[%s] Role[%s]", name, surname, role));
    }
}

