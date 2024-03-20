package uk.ac.ucl.requirements;

import java.util.ArrayList;

public class JSONWriter {

    public static String toJson(DataFrame dataFrame) {
        ArrayList<Column> columns = (ArrayList<Column>) dataFrame.getColumns();
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n"); // Start of JSON array

        for (int rowIndex = 0; rowIndex < dataFrame.getRowCount(); rowIndex++) {
            jsonBuilder.append("  {"); // Start of JSON object
            for (int colIndex = 0; colIndex < columns.size(); colIndex++) {
                Column column = columns.get(colIndex);
                jsonBuilder.append("\"").append(escapeJson(column.getName())).append("\": ");
                String value = escapeJson(column.getRowValue(rowIndex));
                jsonBuilder.append("\"").append(value).append("\"");

                if (colIndex < columns.size() - 1) {
                    jsonBuilder.append(", "); // Comma between key-value pairs
                }
            }
            jsonBuilder.append("}"); // End of JSON object
            if (rowIndex < dataFrame.getRowCount() - 1) {
                jsonBuilder.append(",\n"); // Comma between objects
            } else {
                jsonBuilder.append("\n"); // Last row
            }
        }

        jsonBuilder.append("]"); // End of JSON array
        return jsonBuilder.toString();
    }

    private static String escapeJson(String value) {
        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
