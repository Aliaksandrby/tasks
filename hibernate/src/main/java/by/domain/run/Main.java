/*
* Задание 1 (я так понимаю относиться к 2):
* Создайте стандартный проект maven. Настройте зависимости. Создайте
* конфигурацию и соберите проект. Настройте отображение для сущности с помощью jpa
* annotation. Запустите приложение и проверьте его работоспособность. Проверьте, что
* все библиотеки есть в наличии. (стр 105)
*
* Задание 2:
* Измените созданное ранее приложение. Добавьте функциональность по
* сохранению, удалению и поиск вашей сущности. Написанное проверьте с помощью jUnit
* тестов. Приложение должно собираться с помощью maven и запускаться с помощью
* команды java -jar <имя вашего приложения>.jar. (стр 110)
*
* Практическое задание 1:
* Создайте два метода в вашем приложении. Один будет загружать объект из базы
* данных с помощью метода get(), а другой - с помощью метода load(). Внесите данные в
* базу, а затем загрузите объект, используя оба выше описанных метода.
* Проанализируйте результат. А затем попробуйте загрузить данные из базы для
* несуществующего идентификатора и проверить работу приложения. Можно усложнить
* реализацию путем добавления системы обработки исключений и применением
* транзакций. (стр 111)
*
* Задание 3:
* Добавьте в ваше приложение методы, которые синхронизируют состояние базы
* данных с состоянием объекта. Используйте триггеры, очистку сессии и синхронизацию
* состояния объектов сессии с состоянием базы данных. Опишите сложности при
* использовании выше описанных методов. (стр 112)
*
* Практическое задание 2:
* Добавьте в ваше приложение методы, которые удаляют объект из базы данных.
* Реализуйте перегруженные методы, которые сперва создают объект в базе, а потом
* удаляют. Опишите проблемы, с которыми вы столкнулись при выполнении этого задания. (стр 113)
*/

package by.domain.run;

import by.domain.DAO.SongDao;
import by.domain.DAO.SongDaoImpl;
import by.domain.conf.DataConfig;
import by.domain.conf.MysqlSessionFactory;
import by.domain.pojo.Song;
import org.hibernate.Session;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = MysqlSessionFactory
                .getInstance(DataConfig.JDBC_PROPERTIES,DataConfig.HIBERNATE_PROPERTIES)
                .openSession();

        SongDao songDao = new SongDaoImpl(session);

        List<Song> songs = new SongList(10).getSongs();
        for (Song element : songs) songDao.saveSong(element);

        Song song1 = songDao.loadObjFromDB(1);
        System.out.println(song1);

        songDao.deleteSong("songs",song1);

        Song song2 = songDao.getObjFromDB(2);
        System.out.println(song2);

        Song song3 = songDao.findSongById(3); // find ResultSet; don't use this method before delete some entity
        System.out.println(song3);
    }
}
