package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {

//    OrderService orderService;

//    @BeforeEach
//    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
//        orderService = appConfig.orderService();
//    }

    @Test
    void createOrder() {

        Long memberId = 1L;

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = orderService.getMemberRepository();

        memberRepository.save(new Member(memberId, "name", Grade.VIP));

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
