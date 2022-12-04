/*
* Задание 10:
* Реализуйте Spring проект. Сконфигурируйте beans с использованием атрибута
* component-scan и include-filter. Запустите приложение и проверьте работоспособность. (стр 177)
*/

package by.domain.run;

import by.domain.configuration.ComponentScanIncludeFilterConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task10Spring {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(ComponentScanIncludeFilterConfig.class);
        Beans.show(applicationContext.getBeanDefinitionNames());
    }
}
