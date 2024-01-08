package tom.study.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import tom.study.logger.AbstractTemplate;
import tom.study.logger.LogTrace;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RepositoryV0 {

   private final LogTrace trace;

    public void helloRepository() {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                log.info("test repo");
                return null;
            }
        };
        template.execute("Repository test");
    }
}
