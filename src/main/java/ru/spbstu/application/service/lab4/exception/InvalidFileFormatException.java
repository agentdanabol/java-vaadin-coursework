package ru.spbstu.application.service.lab4.exception;

public class InvalidFileFormatException extends Exception {

    public InvalidFileFormatException() {
        super("Формат входного файла неверный");
    }

}