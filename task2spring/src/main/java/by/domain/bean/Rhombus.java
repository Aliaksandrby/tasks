package by.domain.bean;

public class Rhombus {

    private Rhombus() {
    }

    public static Rhombus getRhombus() {
        return new Rhombus();
    }

    @Override
    public String toString() {
        return "Rhombus is also factory-method";
    }
}
