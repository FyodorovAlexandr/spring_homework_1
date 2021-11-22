package ru.iteco.spring_homework_1.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.cache.annotation.CacheResult;

public class PrintBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PrintBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            CacheResult annotation = null;
            String beanName = beanDefinition.getBeanClassName();

            try {
                Class<?> beanClass = Class.forName(beanName);
                annotation = beanClass.getAnnotation(CacheResult.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (beanDefinition.isPrototype() && annotation != null) {
                logger.warn(beanName + " contains Scope=Prototype and annotation @CacheResult");
            }
        }
    }
}
