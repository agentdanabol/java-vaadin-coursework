package ru.spbstu.application.service.lab1;

public class Flight implements MovingStrategy{

    @Override
    public Point move(Point point) {
        System.out.println("Лечу в точку: " + point);
        return new Point(point.getX(), point.getY());
    }

}
