package by.domain.factory;

import by.domain.bean.Figure;
import by.domain.bean.Hexagon;
import by.domain.bean.Square;

public class FigureFactory {
    public Figure getFigure(String typeFigure) {
        if (typeFigure.equalsIgnoreCase("Hexagon")) {
            return new Hexagon();
        }
        if (typeFigure.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
