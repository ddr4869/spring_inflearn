package tom.study.TomTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TomTest {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;

    @Test
    void OneToManyTest() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("test");

        User user = new User();
        user.setId(1L);
        user.setName("tom");

        postRepo.save(post);
        userRepo.save(user);



    }
}
