package tom.study.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tom.study.logger.AbstractTemplate;
import tom.study.logger.LogTrace;
import tom.study.logger.TraceCallBack;
import tom.study.logger.TraceTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ControllerV0 {
    private final ServiceV0 serviceV0;
    private final LogTrace trace;
    private final TraceTemplate template;


    @GetMapping("/tom/hello")
    public String helloController() {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                serviceV0.helloService();
                return "OK";
            }
        };
        return template.execute("Controller test");
    }
}

