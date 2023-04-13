package ru.spbstu.application.service.lab6;

import java.util.List;

public record Supervisor(AbstractProgram program, List<String> container) implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (program) {
                    container.add(program.getState().toString());
                    if (program.getState() == State.STOPPING) {
                        container.add("STOPPING. Restarting the program...");
                        program.wait();
                    }
                    if (program.getState() == State.FATAL_ERROR) {
                        container.add("FATAL ERROR. Finishing process...");
                        return;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
