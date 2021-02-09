package com.epam.task.third.repo;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecification;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TetrahedronRepositoryImplementation implements TetrahedronRepository {

    private final Map<Integer, Tetrahedron> repoMap = new HashMap<>();
    private int id = 0;

    @Override
    public void addTetrahedron(Tetrahedron tetrahedron) throws TetrahedronIsNotRegularException {
        if (isRegular(tetrahedron)) {
            while (repoMap.containsKey(id)) {
                id++;
            }
            repoMap.put(id, tetrahedron);
        } else {
            throw new TetrahedronIsNotRegularException("Not regular");
        }
    }

    @Override
    public void removeTetrahedron(int id) {
        repoMap.remove(id);
    }

    @Override
    public void replaceTetrahedron(int id, Tetrahedron tetrahedron) throws TetrahedronIsNotRegularException {
        if (isRegular(tetrahedron)) {
            repoMap.replace(id, tetrahedron);
        } else {
            throw new TetrahedronIsNotRegularException("Not regular");
        }
    }

    @Override
    public List<Tetrahedron> query(TetrahedronSpecification specification) {
        List<Tetrahedron> specifiedList = new ArrayList<>();
        for (Tetrahedron tetrahedron : repoMap.values()) {
            if (specification.specified(tetrahedron)) {
                specifiedList.add(tetrahedron);
            }
        }
        return specifiedList;
    }

    private boolean isRegular(Tetrahedron tetrahedron) {
        return new RegularTetrahedronValidator(tetrahedron).validate();
    }

    public Map<Integer, Tetrahedron> getRepoMap() {
        return repoMap;
    }
}
