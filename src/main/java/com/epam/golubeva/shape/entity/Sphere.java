package com.epam.golubeva.shape.entity;

import com.epam.golubeva.shape.exception.ShapeException;
import com.epam.golubeva.shape.observer.CustomerObserver;
import com.epam.golubeva.shape.observer.Observable;
import com.epam.golubeva.shape.observer.SphereEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends CustomerShape implements Observable {
    private CustomerPoint center;
    private CustomerPoint boundary;
    private double radius;
    private List<CustomerObserver> observers = new ArrayList<>();
    private static Logger LOGGER = LogManager.getLogger(Sphere.class);
    public Sphere(){

    }

    public Sphere(CustomerPoint center, CustomerPoint boundary, double radius)  {
        super();
       this.center=center;
        this.radius = radius;
    }

    public Sphere(CustomerPoint center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public CustomerPoint getCenter() {
        return center;
    }

    public void setCenter(CustomerPoint center) {
        this.center = center;
        notifyObservers();
    }

    public CustomerPoint getBoundary() {
        return boundary;
    }

    public void setBoundary(CustomerPoint boundary) {
        this.boundary = boundary;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        Sphere other = (Sphere) o;
        if (boundary == null) {
            if (other.boundary != null)
                return false;
        } else if (!boundary.equals(other.boundary))
            return false;
        if (center == null) {
            if (other.center != null)
                return false;
        } else if (!center.equals(other.center))
            return false;
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((boundary == null) ? 0 : boundary.hashCode());
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Sphere [center=");
        builder.append(center);
        builder.append(", boundary=");
        builder.append(boundary);
        builder.append(", radius=");
        builder.append(radius);
        builder.append("]\n");
        return builder.toString();
    }

    @Override
    public void attach(CustomerObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(CustomerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        SphereEvent event = new SphereEvent(this);
        for (CustomerObserver observer : observers) {
            try {
                observer.parameterChanged(event);
            } catch (ShapeException e) {
                LOGGER.log(Level.ERROR, "exception impossible");
            }
        }
    }
}
