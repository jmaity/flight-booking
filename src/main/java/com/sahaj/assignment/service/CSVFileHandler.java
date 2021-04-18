package com.sahaj.assignment.service;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sahaj.assignment.model.PassengerDetail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileHandler implements FileHandler {
    @Override
    public List<PassengerDetail> readFileDate(String fileName) throws FileNotFoundException {
        List<PassengerDetail> passengerDetailList = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(PassengerDetail.class)
                .build()
                .parse();

        return passengerDetailList;
    }

    @Override
    public void writeFileData(List<?> objects, String fileName, Class c) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(c);
        StatefulBeanToCsvBuilder<Object> builder = new StatefulBeanToCsvBuilder<Object>(writer);
        StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();
        try {
            beanWriter.write(objects);
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
        writer.close();
    }
}
