package com.epam.task.third.repo.specifications;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;

public class TetrahedronSpecificationWhenVolumeMoreThan implements TetrahedronSpecification {

    private double volume;
    private final TetrahedronCalculator calculator = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;

    public TetrahedronSpecificationWhenVolumeMoreThan(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
            return calculator.calculateTetrahedronVolume(tetrahedron) - THRESHOLD > volume;

    }
}
