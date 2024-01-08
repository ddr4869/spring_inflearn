package tom.study.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tom.study.logger.AbstractTemplate;
import tom.study.logger.LogTrace;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceV0 {
    private final RepositoryV0 repositoryV0;
    private final LogTrace trace;
    public void helloService() {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                repositoryV0.helloRepository();
                return null;
            }
        };
        template.execute("Service test");
    }
}

