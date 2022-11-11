package by.domain.run;

import by.domain.bean.Hexagon;
import by.domain.bean.Square;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public Runner() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("beans.xml")) {
            Hexagon hexagon = context.getBean(Hexagon.class);
            hexagon.paint();
            Square square = context.getBean(Square.class);
            square.paint();
        }
    }
}
