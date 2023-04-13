package ru.spbstu.application.service.lab3;

import ru.spbstu.application.service.lab3.animals.Chordate;

import java.util.Objects;

abstract public class ChordateAbstract {
    private String name;

    public ChordateAbstract(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chordate chordate = (Chordate) o;
        return Objects.equals(getName(), chordate.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
