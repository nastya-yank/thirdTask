package com.epam.golubeva.shape.observer;

public interface Observable {
        void attach(CustomerObserver observer);
        void detach(CustomerObserver observer);
        void notifyObservers();
    }

