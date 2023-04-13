package ru.spbstu.application.service.lab1;

public class Walk implements MovingStrategy {

    @Override
    public Point move(Point point) {
        System.out.println("Иду пешком в точку: " + point);
        return new Point(point.getX(), point.getY());
    }

}
