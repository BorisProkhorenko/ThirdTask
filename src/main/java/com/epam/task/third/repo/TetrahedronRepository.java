package com.epam.task.third.repo;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecification;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;

import java.util.List;

public interface TetrahedronRepository {

    void addTetrahedron(Tetrahedron tetrahedron) throws TetrahedronIsNotRegularException;

    void removeTetrahedron(int id);

    void replaceTetrahedron(int id, Tetrahedron tetrahedron) throws TetrahedronIsNotRegularException;

    List<Tetrahedron> query(TetrahedronSpecification specification);
}
