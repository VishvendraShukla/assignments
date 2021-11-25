package com.CSVExport.CSVExporter.Repository;

import com.CSVExport.CSVExporter.Model.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSVRepository extends JpaRepository<MyTable, Integer> {
}
