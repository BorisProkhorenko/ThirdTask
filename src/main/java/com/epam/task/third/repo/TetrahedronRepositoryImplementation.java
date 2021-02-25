package com.epam.task.third.repo;

import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TetrahedronRepositoryImplementation implements TetrahedronRepository {

    private final Map<Integer, Tetrahedron> repoMap = new HashMap<>();
    private int id = 0;

    @Override
    public void addTetrahedron(Tetrahedron tetrahedron){
            while (repoMap.containsKey(id)) {
                id++;
            }
            repoMap.put(id, tetrahedron);
    }

    @Override
    public void removeTetrahedron(int id) {
        repoMap.remove(id);
    }

    @Override
    public void replaceTetrahedron(int id, Tetrahedron tetrahedron){
            repoMap.replace(id, tetrahedron);
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

    public Tetrahedron getTetrahedronById(int id) {
        return repoMap.get(id);
    }
}
