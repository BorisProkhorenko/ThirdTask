package com.epam.task.third.observers;

import com.epam.task.third.entity.Parameters;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserver implements Observer {

    private TetrahedronCalculator calculator;
    private Map<Tetrahedron, Parameters> parameters;
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
    public void update(Tetrahedron tetrahedron) {
        try {
            double area = calculator.calculateTetrahedronArea(tetrahedron);
            double volume = calculator.calculateTetrahedronVolume(tetrahedron);
            Parameters params = new Parameters(area, volume);
            parameters.put(tetrahedron, params);
        } catch (TetrahedronIsNotRegularException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Parameters> getParameters() {

        return new ArrayList<>(parameters.values());
    }

}


