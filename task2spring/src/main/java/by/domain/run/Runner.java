package by.domain.run;

import by.domain.bean.Hexagon;
import by.domain.bean.Rhombus;
import by.domain.bean.Square;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public Runner() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("beans.xml")) {
            Hexagon hexagon = context.getBean("hexagonSingleton",Hexagon.class);
            hexagon.paint();
            Square square = context.getBean("squareSingleton",Square.class);
            square.paint();

            Rhombus rhombus = context.getBean("rhombus",Rhombus.class);
            System.out.println(rhombus);
        }
    }
}
