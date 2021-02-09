package com.epam.task.third.entity;

import java.util.Objects;

public class Parameters {

    private double area;
    private double volume;

    public Parameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Parameters that = (Parameters) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, volume);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "area=" + area +
                ", volume=" + volume +
                '}';
    }
}
