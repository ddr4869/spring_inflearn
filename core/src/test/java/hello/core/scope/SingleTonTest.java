package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingleTonTest
{
    @Test
    void singletonBeanFind() {
        System.out.println("find SingletonBean0");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        System.out.println("find SingletonBean1");
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        System.out.println("find SingletonBean2");
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        System.out.println("singleton1 = " + singletonBean1);
        System.out.println("singleton2 = " + singletonBean2);
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);


    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
