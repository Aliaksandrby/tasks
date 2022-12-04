/* Задание 15:
 * Реализуйте Spring проект с интеграцией Spring-Hibernate. Реализуйте
 * декларативную транзакционность для методов сервиса с/без использования аннотаций.
 * Запустите приложение, и проверьте работоспособность. (стр 194)
 */

package by.domain;

import by.domain.configAnnotation.DataConfig;
import by.domain.services.IFService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task10SpringHibernate {
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        context.getBean(IFService.class).someOperation();
    }
}
