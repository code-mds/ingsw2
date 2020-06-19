import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final String name;

    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public void printAll() {
        System.out.println(String.format(">> %s ", name));
        for (Component c : components) {
            c.printAll();
        }
    }
}
