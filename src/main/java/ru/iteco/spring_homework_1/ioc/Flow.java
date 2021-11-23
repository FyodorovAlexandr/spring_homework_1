package ru.iteco.spring_homework_1.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_1.ioc.interfaces.ExternalService;
import ru.iteco.spring_homework_1.ioc.interfaces.Process;

@Component
public class Flow {
    private static final Logger logger = LoggerFactory.getLogger(Flow.class);

    private final ExternalService externalService;
    private final Process process;

    public Flow(ExternalService externalService, Process process ) {
        this.externalService = externalService;
        this.process = process;
    }

    public void run(Integer id){
        ExternalInfo externalInfo = externalService.getExternalInfo(id);
        if (externalInfo.getInfo() != null) {
            process.run(externalInfo);
        } else {
            logger.info("Not run process: {}", externalInfo);
        }
    }
}
