/*
* Задание 8:
* Реализуйте Spring проект. Сконфигурируйте beans с использованием
* @Autowired(учитывая ограничения). Запустите приложение и проверьте
* работоспособность. (стр 175)
*
* Задание 9:
Реализуйте Spring проект. Сконфигурируйте beans с использованием
Qualifying Ambiguous Dependencies. Запустите приложение и проверьте
работоспособность. (стр 176)
*/

package by.domain.run;

import by.domain.beans.Car;
import by.domain.conf.ConfigBeans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task8Spring { // del TapeRecorder, everything will work
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(ConfigBeans.class)) {
            context.getBean(Car.class).info();
        }
    }
}
