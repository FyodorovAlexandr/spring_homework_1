package ru.iteco.spring_homework_1.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Flow {
    private static final Logger logger = LoggerFactory.getLogger(Flow.class);

    private final ExternalInfoProcess externalInfoProcess;
    private final ExternalServiceImpl externalService;

    public Flow(@Lazy ExternalInfoProcess externalInfoProcess, ExternalServiceImpl externalService) {
        this.externalInfoProcess = externalInfoProcess;
        this.externalService = externalService;
    }

    void run(Integer id) {
        if (externalService.getExternalInfo(id).getInfo() != null) {
            externalInfoProcess.run(externalService.getExternalInfo(id));
        } else {
            logger.info(String.valueOf(externalInfoProcess.getClass()));
        }
    }
}
