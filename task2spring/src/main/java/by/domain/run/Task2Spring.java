/*
* Задание 2:
* Реализуйте Spring проект. Сконфигурируйте bean через factory-method.
* Сконфигурируйте init, destroy методы с помощью конфигурации контекстов или с
* помощью InitializingBean, DisposableBean. Сконфигурируйте default-init и default-destroy
* методы. Запустите приложение и проверьте результат. (стр 168)
*/

package by.domain.run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//default-init и default-destroy методы будут работать если убрать методы инициализации
//и уничтожения для каждого бина в отдельности и подкорректировать beans.xml
public class Task2Spring {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(Runner.class)) {
            context.getBean("runner",Runner.class);
        }
    }
}
