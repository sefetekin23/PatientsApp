package uk.ac.ucl.requirements;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DataLoader {

    public static DataFrame loadData(String filePath) throws IOException {
        ArrayList<Column> columns = new ArrayList<>();
        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            Map<String, Integer> headerMap = csvParser.getHeaderMap();
            // Initialize columns with the header names
            for (String columnName : headerMap.keySet()) {
                // The first value in the list is the column name
                ArrayList<String> columnData = new ArrayList<>();
                columnData.add(columnName); // Add the column name as the first element
                columns.add(new Column(columnData));
            }

            // Iterate over the records and add values to the columns
            for (CSVRecord record : csvParser) {
                for (String header : headerMap.keySet()) {
                    int index = headerMap.get(header);
                    Column currentColumn = columns.get(index);
                    currentColumn.addRowValue(record.get(header)); // Add value to the column
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            throw e; // It's better to throw the exception to allow the caller to handle it
        }

        return new DataFrame(columns);
    }
}
