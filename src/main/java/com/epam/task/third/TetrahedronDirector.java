package com.epam.task.third;

import com.epam.task.third.creators.TetrahedronCreator;
import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.parsing.TetrahedronPointsParser;
import com.epam.task.third.validation.InputLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronDirector {

    private DataReader reader;
    private InputLineValidator validator;
    private TetrahedronPointsParser parser;
    private static final Logger LOGGER = LogManager.getLogger();


    public TetrahedronDirector(DataReader reader, InputLineValidator validator,
                               TetrahedronPointsParser parser) {
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Tetrahedron> createList(String filePath) throws DataException {
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        TetrahedronCreator creator = new TetrahedronCreator();
        try {
            List<String> data = reader.readData(filePath);
            for (String line : data) {
                if (validator.validate(line)) {
                    Tetrahedron tetrahedron = creator.create(line, parser);
                    tetrahedronList.add(tetrahedron);
                }
            }
        } catch (DataException e) {
            LOGGER.error(e.getMessage());
        }
        return tetrahedronList;
    }

}
