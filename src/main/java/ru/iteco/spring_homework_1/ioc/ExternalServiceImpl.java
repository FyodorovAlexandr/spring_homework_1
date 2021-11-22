package ru.iteco.spring_homework_1.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.iteco.spring_homework_1.ioc.interfaces.ExternalService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.cache.annotation.CacheResult;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExternalServiceImpl implements ExternalService {

    private static final Logger logger = LoggerFactory.getLogger(ExternalServiceImpl.class);
    private Map<Integer, ExternalInfo> hashMap = new HashMap<>();

    @CacheResult
    @Override
    public ExternalInfo getExternalInfo(Integer id) {
        logger.info("Calling the getExternalInfo method");
        return hashMap.get(id);
    }

    @PostConstruct
    public void init() {
        hashMap.put(1, new ExternalInfo(1, null));
        hashMap.put(2, new ExternalInfo(2, "hasInfo"));
        hashMap.put(3, new ExternalInfo(3, "info"));
        hashMap.put(4, new ExternalInfo(3, "information"));
        logger.info("Filling HashMap with test data");
    }

    @PreDestroy
    public void destroy() {
        hashMap.clear();
        logger.info("HashMap cleared");
    }
}
