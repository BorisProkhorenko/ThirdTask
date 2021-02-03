package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.parsing.TetrahedronParser;
import com.epam.task.third.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class RegularTetrahedronListCreator {

   private DataReader reader;
   private Validator<String> lineValidator;
   private Validator<Tetrahedron> regularityValidator;
   private TetrahedronParser parser;

    public RegularTetrahedronListCreator(DataReader reader, Validator<String> lineValidator,
                                         Validator<Tetrahedron> regularityValidator, TetrahedronParser parser) {
        this.reader = reader;
        this.lineValidator = lineValidator;
        this.regularityValidator = regularityValidator;
        this.parser = parser;
    }

    public List<Tetrahedron> createList(String filePath) {
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        try {
            List<String> data = reader.readData(filePath);
            for (String line : data) {
                if (lineValidator.validate(line)) {
                    TetrahedronParser parser = new TetrahedronParser();
                    Tetrahedron tetrahedron = parser.parse(line);
                    if (regularityValidator.validate(tetrahedron)) {
                        tetrahedronList.add(tetrahedron);
                    }
                }
            }

        } catch (DataException e) {
            e.printStackTrace();
        }

        return tetrahedronList;
    }

    public DataReader getReader() {
        return reader;
    }

    public void setReader(DataReader reader) {
        this.reader = reader;
    }

    public Validator<String> getLineValidator() {
        return lineValidator;
    }

    public void setLineValidator(Validator<String> lineValidator) {
        this.lineValidator = lineValidator;
    }

    public Validator<Tetrahedron> getRegularityValidator() {
        return regularityValidator;
    }

    public void setRegularityValidator(Validator<Tetrahedron> regularityValidator) {
        this.regularityValidator = regularityValidator;
    }

    public TetrahedronParser getParser() {
        return parser;
    }

    public void setParser(TetrahedronParser parser) {
        this.parser = parser;
    }

    @Override
    public String toString() {
        return "RegularTetrahedronListCreator{" +
                "reader=" + reader +
                ", lineValidator=" + lineValidator +
                ", regularityValidator=" + regularityValidator +
                ", parser=" + parser +
                '}';
    }
}
