package com.CSVExport.CSVExporter.Controller;

import com.CSVExport.CSVExporter.Model.MyTable;
import com.CSVExport.CSVExporter.Service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CSVController {
    @Autowired
    private CSVService service;

    @RequestMapping("/")
    public String show() {
        return "home";
    }

    @GetMapping("/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/csv");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
            response.setHeader(headerKey, headerValue);

            List<MyTable> Data = service.listAll();

            ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
            String[] csvHeader = {"ID", "Name", "Phone", "Email", "Region", "Country"};
            String[] nameMapping = {"id", "name", "phone", "email", "region", "country"};

            csvWriter.writeHeader(csvHeader);

            for (MyTable data : Data) {
                csvWriter.write(data, nameMapping);
            }

            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
