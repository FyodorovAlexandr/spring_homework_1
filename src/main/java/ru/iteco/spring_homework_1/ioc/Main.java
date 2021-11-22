package ru.iteco.spring_homework_1.ioc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        Flow flow = applicationContext.getBean(Flow.class);
        flow.run(1);
        flow.run(2);
        flow.run(3);
        flow.run(4);

        PrintBeanFactoryPostProcessor printBeanFactoryPostProcessor = new PrintBeanFactoryPostProcessor();
        printBeanFactoryPostProcessor.postProcessBeanFactory(applicationContext.getBeanFactory());
        applicationContext.close();
    }
}
