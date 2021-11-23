package ru.iteco.spring_homework_1.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_1.ioc.anotations.CacheResult;
import ru.iteco.spring_homework_1.ioc.interfaces.Process;

@Lazy
@Scope("prototype")
@Component()
public class ExternalInfoProcess implements Process {

    private static final Logger logger = LoggerFactory.getLogger(ExternalInfoProcess.class);

    @Value("${id}")
    private Integer idNotProcess;

    @CacheResult
    @Override
    public boolean run(ExternalInfo externalInfo) {
        if (externalInfo.getId().equals(idNotProcess)) {
            logger.info("ExternalInfo id " + externalInfo.getId() + " equal to idNotProcess " + idNotProcess);
            return false;
        } else {
            logger.info("ExternalInfo id " + externalInfo.getId() + " not equal to idNotProcess " + idNotProcess);
            return true;
        }
    }
}
