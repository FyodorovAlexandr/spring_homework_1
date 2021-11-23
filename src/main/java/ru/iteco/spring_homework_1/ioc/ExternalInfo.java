package ru.iteco.spring_homework_1.ioc;

public class ExternalInfo {
    private final Integer id;
    private final String info;

    public ExternalInfo(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "ExternalInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
