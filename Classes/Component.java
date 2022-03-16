package Classes;

public class Component {
    String name;

    public Component() {
        name = "default";
    }

    public Component(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}