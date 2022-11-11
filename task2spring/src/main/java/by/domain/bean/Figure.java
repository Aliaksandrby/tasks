package by.domain.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public interface Figure extends InitializingBean, DisposableBean {
    void paint();
}
