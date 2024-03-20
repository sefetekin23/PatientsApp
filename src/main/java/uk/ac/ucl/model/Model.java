package uk.ac.ucl.model;


import uk.ac.ucl.requirements.Column;
import uk.ac.ucl.requirements.DataFrame;
import uk.ac.ucl.requirements.DataLoader;
import uk.ac.ucl.requirements.JSONWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
  private DataFrame dataFrame;

  public Model() {
    this.dataFrame = new DataFrame(new ArrayList<>());
  }

  public void readFile(String fileName) {
    try {
      // Load data into DataFrame from a given file path
      this.dataFrame = DataLoader.loadData(fileName);
    } catch (IOException e) {
      System.err.println("An error occurred while loading the data: " + e.getMessage());
      // Initialize an empty DataFrame to ensure the Model is always in a valid state
      this.dataFrame = new DataFrame(new ArrayList<>());

    }
  }




  public List<String>[] getPatientNamesIDs(String columnName) {
    List<String> patientNames = new ArrayList<>();
    List<String> patientIDs = new ArrayList<>();
    List<String> column = new ArrayList<>();


    if (dataFrame == null) {
      // Handle the case when dataFrame is null
      System.err.println("Data frame is null, data may not have been loaded correctly.");
      List<String>[] output = new ArrayList[3];

      // Assign the ArrayLists to the array
      output[0] = patientNames;
      output[1] = patientIDs;
      output[2] = column;
      return output;
    }
    String First = "FIRST";
    String Second = "LAST";
    String ID = "ID";
    int rowCount = getRowCount();
    for (int i = 0; i < rowCount; i++) {

      patientNames.add(getValue(First, i).replaceAll("\\d+","")+" "+ getValue(Second, i).replaceAll("\\d+",""));
      patientIDs.add(getValue(ID, i));
      column.add(getValue(columnName,i));
    }
    List<String>[] output = new ArrayList[3];

    // Assign the ArrayLists to the array
    output[0] = patientNames;
    output[1] = patientIDs;
    output[2] = column;
    return output;
  }


  public List<String> getColumnNames() {
    // Return the names of all columns
    return this.dataFrame.getColumnNames();
  }
  public String getOldestPerson() {
    // Return the names of all columns
    return this.dataFrame.getOldestPerson();
  }
  public String getMostPopularPlace() {
    // Return the names of all columns
    return this.dataFrame.getMostPopularPlace();
  }
  public String getMostPopularZIP() {
    return this.dataFrame.getMostPopularZIP();
  }
  public Map<String, Integer> getMapBasic(String ColumnName) {
    // Return the names of all columns
    return this.dataFrame.getMapBasic(ColumnName);
  }
  public Map<String, Integer> getMapAge() {
    // Return the names of all columns
    return this.dataFrame.getMapAge();
  }


  public int getRowCount() {
    // Return the number of rows in the DataFrame
    return this.dataFrame.getRowCount();
  }
  public void sortByColumn(String columnName) {
    // Return the number of rows in the DataFrame
    this.dataFrame.sortByColumn(columnName);
  }

  public String getValue(String columnName, int rowNumber) {
    // Get a specific value from the DataFrame
    return dataFrame.getValue(columnName, rowNumber);
  }

  public void putValue(String columnName, int rowNumber, String value) {
    // Update a specific value in the DataFrame
    dataFrame.putValue(columnName, rowNumber, value);
  }

  public void addValue(String columnName, String value) {
    // Add a new value to a specific column in the DataFrame
    dataFrame.addValue(columnName, value);
  }
  public List<String> getPatientInfo(String ID)
  {

    int columnIndex = this.dataFrame.getIDs().indexOf(ID);
    List<String> info = this.dataFrame.getRow(columnIndex,true);
    return info;
  }

  public List<String>[] searchFor(String keyword) {
    List<String> results = new ArrayList<>();
    int rowCount = getRowCount();
    List<String> IDs = new ArrayList<>();
    List<String> columnNames = getColumnNames();

    for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
      String patientFirstName = getValue("FIRST", rowIndex);
      String patientLastName = getValue("LAST", rowIndex);
      for (String columnName : columnNames) {
        String value = getValue(columnName, rowIndex);

        if (value != null && value.toLowerCase().contains(keyword.toLowerCase())) {
          results.add(patientFirstName.replaceAll("\\d","")+" " +patientLastName.replaceAll("\\d","")+"'s "+columnName+" is "+ value);
          IDs.add(this.getPatientNamesIDs("ID")[1].get(rowIndex));
        }
      }
    }
    List<String>[] output = new ArrayList[2];

    // Assign the ArrayLists to the array
    output[0] = results;
    output[1] = IDs;
    return output;
  }

  public String toJson()
  {
    return JSONWriter.toJson(this.dataFrame);
  }



}
