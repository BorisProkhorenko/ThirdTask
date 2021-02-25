package com.epam.task.third.entity;

import com.epam.task.third.observers.Observable;
import com.epam.task.third.observers.Observer;

import java.util.List;


public class TetrahedronObservable extends Tetrahedron implements Observable {

    private List<Observer> observers;
    private int id;

    public TetrahedronObservable(Point a, Point b, Point c, Point d, int id) {
        super(a, b, c, d);
        this.id = id;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.update(this);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void setA(Point a) {
        super.setA(a);
        notifyObservers();
    }

    @Override
    public void setB(Point b) {
        super.setB(b);
        notifyObservers();
    }

    @Override
    public void setC(Point c) {
        super.setC(c);
        notifyObservers();

    }

    @Override
    public void setD(Point d) {
        super.setD(d);
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
