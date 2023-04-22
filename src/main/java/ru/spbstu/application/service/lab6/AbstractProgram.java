package ru.spbstu.application.service.lab6;

import java.util.Random;

public class AbstractProgram implements Runnable {

    private volatile State state;
    private final int changeInterval;
    private Thread daemonThread;

    public AbstractProgram() {
        this.state = State.UNKNOWN;
        this.changeInterval = 10;
        daemonThread = new Thread(this::changeStateToRandom);
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    @Override
    public void run() {
    }

    private void changeStateToRandom() {
        try {
            while (true) {
                Thread.sleep(changeInterval);
                Random random = new Random();
                switch (random.nextInt(4)) {
                    case 0 -> setState(State.STOPPING);
                    case 1 -> setState(State.RUNNING);
                    case 2 -> setState(State.FATAL_ERROR);
                    default -> setState(State.UNKNOWN);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized State getState() {
        return state;
    }

    private synchronized String setState(State newState) {
        this.state = newState;
        notifyAll();
        return "New state: " + newState;
    }

}

