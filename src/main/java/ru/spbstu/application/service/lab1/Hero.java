package ru.spbstu.application.service.lab1;

public class Hero {

    private final static String WALK = "Walk";
    private final static String RIDE = "Ride";
    private final static String FLIGHT = "Flight";
    private MovingStrategy strategy;

    public Hero(int x, int y) {
        this.strategy = new Walk();
        System.out.println("Я заспавнился в точке: " + x + ", " + y);
    }

    public void setStrategy(String type) {
        try{
            switch(type){
                case WALK -> strategy = new Walk();
                case RIDE -> strategy = new Ride();
                case FLIGHT -> strategy = new Flight();
                default -> throw new Exception("Неверно задана стратегия");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void travel(Point point) {
        strategy.move(point);
    }

}