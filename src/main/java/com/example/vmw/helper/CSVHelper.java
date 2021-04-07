package com.example.vmw.helper;

import com.example.vmw.model.Employees;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Firstname", "Lastname", "Age" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<Employees> csvToEmployees(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Employees> employeesObj = new ArrayList<Employees>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Employees employees = new Employees(
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("Firstname"),
              csvRecord.get("Lastname"),
                Long.parseLong(csvRecord.get("Age"))
            );

        employeesObj.add(employees);
      }

      return employeesObj;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream employeesToCSV(List<Employees> employeesList) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (Employees emp : employeesList) {
        List<String> data = Arrays.asList(
              String.valueOf(emp.getId()),
              emp.getFirstname(),
              emp.getLastname(),
              String.valueOf(emp.getAge())
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }

}
