package com.epam.task.third.repo.specifications;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;

public class TetrahedronSpecificationWhenAreaEqualOrLessThan implements TetrahedronSpecification {

    private double area;
    private final TetrahedronCalculator calculator = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;

    public TetrahedronSpecificationWhenAreaEqualOrLessThan(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return calculator.calculateTetrahedronArea(tetrahedron) - THRESHOLD <= area;
    }

}
