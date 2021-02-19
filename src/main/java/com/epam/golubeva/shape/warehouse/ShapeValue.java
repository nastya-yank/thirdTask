package com.epam.golubeva.shape.warehouse;

import java.util.Objects;

public class ShapeValue {
    private double square;
   private double volume;

    public ShapeValue(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }
    public ShapeValue(){

    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        ShapeValue other = (ShapeValue) o;
        if (Double.doubleToLongBits(square) != Double.doubleToLongBits(other.square))
            return false;
        if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(square);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShapeValues [areaSurface=");
        builder.append(square);
        builder.append(", volume=");
        builder.append(volume);
        builder.append("]");
        return builder.toString();
    }
}

