package com.epam.task.third.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public List<String> readData(String filePath) throws DataException {


        List<String> data = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }


        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new DataException(e.getMessage(), e);
            }

        }

        return data;
    }
}
