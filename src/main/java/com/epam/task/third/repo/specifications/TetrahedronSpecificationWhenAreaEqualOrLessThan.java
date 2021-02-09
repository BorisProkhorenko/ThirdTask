package com.epam.task.third.repo.specifications;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.logic.TetrahedronCalculator;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;

public class TetrahedronSpecificationWhenAreaEqualOrLessThan implements TetrahedronSpecification {

    private double area;
    private static final TetrahedronCalculator CALCULATOR = new TetrahedronCalculator();
    private static final double THRESHOLD = 0.0001;

    public TetrahedronSpecificationWhenAreaEqualOrLessThan(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        try {
            return CALCULATOR.calculateTetrahedronArea(tetrahedron) - THRESHOLD <= area;
        } catch (TetrahedronIsNotRegularException e) {
            e.printStackTrace();
            return false;
        }

    }
}
