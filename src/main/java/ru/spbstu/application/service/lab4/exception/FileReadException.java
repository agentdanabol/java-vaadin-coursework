package ru.spbstu.application.service.lab4.exception;

public class FileReadException extends Exception {

    public FileReadException() {
        super("Не удалось прочитать файл!");
    }

}
