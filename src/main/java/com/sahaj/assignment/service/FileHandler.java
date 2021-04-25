package com.sahaj.assignment.service;

import com.sahaj.assignment.model.PassengerDetail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileHandler {
    public List<PassengerDetail> readFileDate(String fileName) throws FileNotFoundException;
    public void writeFileData (List<?> objects, String fileName, Class c, String header) throws IOException;
}
