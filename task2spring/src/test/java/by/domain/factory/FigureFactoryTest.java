package by.domain.factory;

import by.domain.bean.Hexagon;
import by.domain.bean.Square;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class FigureFactoryTest {

    private ClassPathXmlApplicationContext testContext;

    @Before
    public void setUp() {
        testContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public void tearDown() {
        testContext.close();
    }

    @Test
    public void testSquareBeans() {
        Object squareBean0 = testContext.getBean(Square.class);
        assertNotNull(squareBean0);

        Object squareBean1 = testContext.getBean(Square.class);
        assertNotNull(squareBean1);

        assertEquals(squareBean0,squareBean1);
    }

    @Test
    public void testHexagonBeans() {
        Object hexagonBean0 = testContext.getBean(Hexagon.class);
        assertNotNull(hexagonBean0);

        Object hexagonBean1 = testContext.getBean(Hexagon.class);
        assertNotNull(hexagonBean1);

        assertEquals(hexagonBean0,hexagonBean1);
    }

    @Test
    public void testMixBeans() {
        Object hexagonBean0 = testContext.getBean(Hexagon.class);
        assertNotNull(hexagonBean0);
        Object squareBean0 = testContext.getBean(Square.class);
        assertNotNull(squareBean0);

        //assertEquals(hexagonBean0,squareBean0); // fall down
    }
}