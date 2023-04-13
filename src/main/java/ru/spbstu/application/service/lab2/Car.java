package ru.spbstu.application.service.lab2;

public class Car {

    private String model;
    private String owner;
    private String description;

    public Car(String model, String owner, String description) {
        this.model = model;
        this.owner = owner;
        this.description = description;
    }

    @MyAnnotation(count = 2)
    private String printDescription() {
        return "Максимальная скорость: " + description;
    }

    @MyAnnotation(count = 3)
    public String printOwner() {
        return "Владелец автомобиля: " + owner;
    }

    @MyAnnotation(count = 4)
    protected String printModel() {
        return "Модель автомобиля: " + model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

}