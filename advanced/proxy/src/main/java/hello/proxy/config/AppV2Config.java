package hello.proxy.config;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {
    public OrderControllerV2 orderControllerV2() {
        return new OrderControllerV2(orderServicev2());
    }

    @Bean
    public OrderServiceV2 orderServicev2() {
        return new OrderServiceV2(orderRepositoryV2());
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2() {
        return new OrderRepositoryV2();
    }
}
