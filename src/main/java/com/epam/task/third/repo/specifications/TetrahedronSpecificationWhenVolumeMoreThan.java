package com.epam.task.third.repo.specifications;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;

public class TetrahedronSpecificationWhenVolumeMoreThan implements TetrahedronSpecification {

    private double volume;
    private static final TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;

    public TetrahedronSpecificationWhenVolumeMoreThan(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        try {
            return CALCULATOR.calculateTetrahedronVolume(tetrahedron) - THRESHOLD > volume;
        } catch (TetrahedronIsNotRegularException e) {
            e.printStackTrace();
            return false;
        }
    }
}
