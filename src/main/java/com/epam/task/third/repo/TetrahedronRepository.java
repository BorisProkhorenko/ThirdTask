package com.epam.task.third.repo;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecification;

import java.util.List;

public interface TetrahedronRepository {

    void addTetrahedron(Tetrahedron tetrahedron);

    void removeTetrahedron(int id);

    void replaceTetrahedron(int id, Tetrahedron tetrahedron);

    List<Tetrahedron> query(TetrahedronSpecification specification);
}
