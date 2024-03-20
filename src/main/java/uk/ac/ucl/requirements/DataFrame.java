package uk.ac.ucl.requirements;

import java.util.*;

public class DataFrame {
    private ArrayList<Column> columns;

    public DataFrame(ArrayList<Column> columns)
    {
        this.columns=columns;
    }
    public void addColumn(ArrayList<String> column)
    {
        this.columns.add(new Column(column));
    }
    public ArrayList<String> getColumnNames()
    {
        ArrayList<String> columnNames = new ArrayList<String>();
        for(Column column:this.columns)
        {
            columnNames.add(column.getName());
        }
        return columnNames;
    }
    public int getRowCount()
    {
        if (this.columns.isEmpty()) {
            // No columns, so row count is 0
            return 0;
        } else {
            return this.columns.get(0).getSize(); // Use get(0) instead of getFirst() to avoid NoSuchElementException
        }
    }
    public String getValue(String columnName, int rowNumber)
    {
        try{

            return this.columns.get(getColumnNames().indexOf(columnName)).getRowValue(rowNumber);
        }
        catch (Exception e)
        {
            return "---";
        }

    }
    public void putValue(String columnName, int rowNumber, String value)
    {
        this.columns.get(getColumnNames().indexOf(columnName)).addRowValue(rowNumber,value);
    }
    public void addValue(String columnName, String value)
    {
        this.columns.get(getColumnNames().indexOf(columnName)).addRowValue(value);
    }
    public List<String> getIDs()
    {
        ArrayList<String> IDs = new ArrayList<String>();
        int index = this.getColumnNames().indexOf("ID");

        return this.columns.get(index).getRows();
    }


    public List<Column> getColumns()
    {
        return this.columns;
    }


    public List<String> getRow(int index,boolean withName)
    {
        List<String> info = new ArrayList<>();
        for(Column a : columns)
        {
            if (withName)
                info.add(a.getName()+": "+a.getRowValue(index));
            else
                info.add(a.getRowValue(index));

        }
        return info;
    }
    public void sortByColumn(String columnName) {
        int columnIndex = getColumnIndex(columnName);
        int firstIndex = getColumnIndex("FIRST");
        if (columnIndex == -1) {
            System.out.println("Column not found");
            return;
        }

        // Get all rows as a list of lists for sorting
        List<List<String>> rows = getRowsAsListOfLists();

        // Sort the rows based on the specified column
        // Adjusting Comparator to place empty values at the end
        Collections.sort(rows, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> row1, List<String> row2) {
                String val1 = row1.get(columnIndex);
                String val2 = row2.get(columnIndex);
                String def1 = row1.get(firstIndex);
                String def2 = row2.get(firstIndex);
                // Check if either value is empty and adjust ordering
                if (val1.isEmpty() && val2.isEmpty()) {
                    return def1.compareTo(def2); // Both empty, consider equal
                } else if (val1.isEmpty()) {
                    return 1; // Put val1 at the end
                } else if (val2.isEmpty()) {
                    return -1; // Keep val2 at the end
                }
                return val1.compareTo(val2); // Normal string comparison
            }
        });

        // Update the original columns based on the sorted rows
        updateColumnsFromSortedRows(rows);
    }
    public String getOldestPerson() {
        Column birthDates = getColumns().get(getColumnIndex("BIRTHDATE"));
        Column deathdateDates = getColumns().get(getColumnIndex("DEATHDATE"));

        Column firsts = getColumns().get(getColumnIndex("FIRST"));
        Column lasts = getColumns().get(getColumnIndex("LAST"));


        String min = "99999";
        int index=-1;
        for (int i =0;i<getRowCount();i++)
        {
            if(deathdateDates.getRowValue(i).isEmpty() && birthDates.getRowValue(i).compareTo(min)<0)
            {
                min = birthDates.getRowValue(i);
                index=i;
            }
        }
        return "Oldest Person is " +firsts.getRowValue(index) + " "+lasts.getRowValue(index)+" with the birthday: "+ min;

    }
    public String getMostPopularZIP() {
        Column Zips = getColumns().get(getColumnIndex("ZIP"));
        Map<String, Integer> places = new HashMap<>();

        int index=-1;
        for (int i =0;i<getRowCount();i++)
        {
            String zip =Zips.getRowValue(i);
            if (!places.containsKey(zip))
            {
                places.put(zip,1);
            }
            else
            {
                places.replace(zip,places.get(zip)+1);
            }

        }
        int max=-1;
        String maxZip="";
        for (String place: places.keySet())
        {
            if (places.get(place)>max)
            {
                max=places.get(place);
                maxZip=place;
            }

        }
        String maxPlace= getColumns().get(getColumnIndex("CITY")).getRowValue( Zips.indexOf(maxZip));
        return "The Most Popular ZIP Code is "+maxZip;
    }

    public String getMostPopularPlace() {
        Column Cities = getColumns().get(getColumnIndex("CITY"));
        Map<String, Integer> places = new HashMap<>();

        int index=-1;
        for (int i =0;i<getRowCount();i++)
        {
            String City =Cities.getRowValue(i);
            if (!places.containsKey(City))
            {
                places.put(City,1);
            }
            else
            {
                places.replace(City,places.get(City)+1);
            }

        }
        int max=-1;
        String maxCity="";
        for (String place: places.keySet())
        {
            if (places.get(place)>max)
            {
                max=places.get(place);
                maxCity=place;
            }

        }
        String maxState= getColumns().get(getColumnIndex("STATE")).getRowValue( Cities.indexOf(maxCity));
        return "The City with Highest Population is "+maxCity+ ", "+maxState;
    }

    public Map<String, Integer> getMapBasic(String columnName) {
        Column Cities = getColumns().get(getColumnIndex(columnName));
        Map<String, Integer> places = new TreeMap<>();

        int index=-1;
        for (int i =0;i<getRowCount();i++)
        {
            String City =Cities.getRowValue(i);
            places.merge(City, 1, Integer::sum);
        }
        return places;
    }

    public Map<String, Integer> getMapAge() {
        Column birthdates = getColumns().get(getColumnIndex("BIRTHDATE"));
        Column deathdates = getColumns().get(getColumnIndex("DEATHDATE"));

        Comparator<String> ageComparator = (o1, o2) -> {
            if ("Dead".equals(o1)) return 1;
            if ("Dead".equals(o2)) return -1;
            return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
        };

        Map<String, Integer> AgesMap = new TreeMap<>(ageComparator);
        int deadCount=0;
        int index=-1;
        for (int i =0;i<getRowCount();i++)
        {
            String birthdate=birthdates.getRowValue(i);
            String deathdate=deathdates.getRowValue(i);
            if(deathdate.isEmpty())
            {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                String age = Integer.toString(year-Integer.parseInt(birthdate.substring(0,birthdate.indexOf('-'))));
                AgesMap.merge(age, 1, Integer::sum);
            }
            else
            {
                deadCount++;
            }

        }
        AgesMap.put("Dead", deadCount);


        return AgesMap;
    }



    private int getColumnIndex(String columnName) {
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).getName().equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        return -1; // Column name not found
    }

    private List<List<String>> getRowsAsListOfLists() {
        List<List<String>> rows = new ArrayList<>();
        int rowCount = getRowCount();

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            List<String> row = new ArrayList<>();
            for (Column column : columns) {
                row.add(column.getRowValue(rowIndex));
            }
            rows.add(row);
        }

        return rows;
    }

    private void updateColumnsFromSortedRows(List<List<String>> sortedRows) {
        // Clear existing column data
        for (Column column : columns) {
            column.clearRows();
        }

        // Update columns with sorted data
        for (List<String> row : sortedRows) {
            for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
                columns.get(columnIndex).addRowValue(row.get(columnIndex));
            }
        }
    }

}
