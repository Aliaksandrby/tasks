package by.domain.run;

public class Beans {
    public static void show(String [] appContextArray) {
        for (String beanName : appContextArray) {
            if (!beanName.contains("org.")) System.out.println(beanName);
        }
    }
}
