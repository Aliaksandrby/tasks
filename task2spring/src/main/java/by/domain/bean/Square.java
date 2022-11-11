package by.domain.bean;

public class Square implements Figure {

    private final String description = "method Square";

    @Override
    public void paint() {
        System.out.println("paint " + this.getClass().getName());
    }

    public void defaultInitMethod() {
        System.out.println("defaultInitMethod " + description);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet " + description);
    }

    public void init() {
        System.out.println("init " + description);
    }

    public void defaultDestroyMethod() {
        System.out.println("defaultDestroyMethod " + description);
    }

    @Override
    public void destroy() {
        System.out.println("destroy " + description);
    }

    public void destroyIntoBeansXml() {
        System.out.println("destroyIntoBeansXml " + description);
    }
}
