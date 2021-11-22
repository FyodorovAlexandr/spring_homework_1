package ru.iteco.spring_homework_1.ioc.interfaces;

import ru.iteco.spring_homework_1.ioc.ExternalInfo;

public interface ExternalService {
    ExternalInfo getExternalInfo(Integer id);
}
