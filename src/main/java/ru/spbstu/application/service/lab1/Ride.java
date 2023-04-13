package ru.spbstu.application.service.lab1;

public class Ride implements MovingStrategy {

    @Override
    public Point move(Point point) {
        System.out.println("Еду верхом в точку: " + point);
        return new Point(point.getX(), point.getY());
    }

}