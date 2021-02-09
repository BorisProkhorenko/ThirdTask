package com.epam.task.third.entity;

import com.epam.task.third.observers.Observable;
import com.epam.task.third.observers.Observer;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronObservable extends Tetrahedron implements Observable {

    private Observer observer;
    private RegularTetrahedronValidator validator;
    private static final Logger LOGGER = LogManager.getLogger();

    public TetrahedronObservable(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        validator = new RegularTetrahedronValidator(a, b, c, d);
    }

    @Override
    public void addObserver(Observer observer) {
        this.observer = observer;
        observer.update(this);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public void setA(Point a) {
        super.setA(a);
        checkIsTetrahedronRegularAndNotifyObserverIfTrue();
    }

    @Override
    public void setB(Point b) {
        super.setB(b);
        checkIsTetrahedronRegularAndNotifyObserverIfTrue();
    }

    @Override
    public void setC(Point c) {
        super.setC(c);
        checkIsTetrahedronRegularAndNotifyObserverIfTrue();

    }

    @Override
    public void setD(Point d) {
        super.setD(d);
        checkIsTetrahedronRegularAndNotifyObserverIfTrue();
    }

    private void checkIsTetrahedronRegularAndNotifyObserverIfTrue() {
        if (validator.validate()) {
            notifyObserver();
            LOGGER.log(Level.INFO, "Tetrahedron is regular so parameters were updated");
        } else {
            LOGGER.log(Level.INFO, "Tetrahedron is not regular so parameters were not updated");
        }
    }


}
