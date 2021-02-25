package com.epam.task.third.observers;

import com.epam.task.third.entity.Parameters;
import com.epam.task.third.entity.TetrahedronObservable;
import com.epam.task.third.logic.TetrahedronCalculator;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserver implements Observer {

    private TetrahedronCalculator calculator;
    private Map<Integer, Parameters> parameters;
    private static TetrahedronObserver instance;


    private TetrahedronObserver() {
        calculator = new TetrahedronCalculator();
        parameters = new HashMap<>();
    }

    public static TetrahedronObserver getInstance() {
        if (instance == null) {
            instance = new TetrahedronObserver();
        }
        return instance;
    }


    @Override
    public void update(TetrahedronObservable tetrahedron) {
        double area = calculator.calculateTetrahedronArea(tetrahedron);
        double volume = calculator.calculateTetrahedronVolume(tetrahedron);
        Parameters params = new Parameters(area, volume);
        parameters.put(tetrahedron.getId(), params);
    }

    public Parameters getParametersById(int id) {

        return parameters.get(id);
    }

}


