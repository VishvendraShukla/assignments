package com.CSVExport.CSVExporter.Service;

import com.CSVExport.CSVExporter.Model.MyTable;
import com.CSVExport.CSVExporter.Repository.CSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSVService implements CSVServiceInterface {
    @Autowired
    private CSVRepository repository;

    @Override
    public List<MyTable> listAll() {
        return repository.findAll();
    }
}
