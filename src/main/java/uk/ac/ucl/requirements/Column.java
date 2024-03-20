package uk.ac.ucl.requirements;

import java.util.ArrayList;

public class Column {
    private String columnName;
    private ArrayList<String> rows;

    public Column(ArrayList<String> rowsInput)
    {
        this.columnName=rowsInput.getFirst();
        this.rows=new ArrayList<>(rowsInput.subList(1, rowsInput.size()));
    }
    public String getName()
    {
        return this.columnName;
    }
    public int getSize()
    {
        return this.rows.size();
    }

    public String getRowValue(int rowNumber)
    {
        return this.rows.get(rowNumber);
    }
    public void setRowValue(int rowNumber, String changedValue)
    {
        this.rows.set(rowNumber,changedValue);
    }
    public void addRowValue(int rowNumber, String value)
    {
        this.rows.add(rowNumber,value);
    }
    public void addRowValue( String value)
    {
        this.rows.add(value);
    }
    public ArrayList<String> getRows()
    {
        return this.rows;
    }
    public void clearRows() {
        this.rows.clear();
    }
    public int indexOf(String a)
    {
        return rows.indexOf(a);
    }
}
