package j1_l_p0002;

import java.util.ArrayList;
import java.util.List;

/**
 * This class use to create dynamic table, option for us. Creating table become
 * more easily and efficiency. By create a CreateTable object, add each
 * attribute for each column. At the same time add ArrayList isNumbers contains
 * boolean value. It support for draw table. All attribute, record, value need
 * turn into String before add to dataSet. Date 5/15/2022.
 *
 * @author Nguyen Xuan Quang Vinh - CE170144
 * @version 1.0.1
 */
public class CreateTable {

    // Contains All attributes user add to object
    private ArrayList<String> attributes = new ArrayList<>();
    private ArrayList<Integer> maxSize = new ArrayList<>();
    private ArrayList<Boolean> isNumbers = new ArrayList<>();

    /**
     * Constructs a CreateTable object without any attribute. User can add
     * attribute to use.
     */
    public CreateTable() {

    }

    /**
     * Constructs a CreateTable object with full attributes, maxSize, and
     * isNumbers. All information need is available
     *
     * @param attributes List of attributes of your table
     * @param maxSize List of default size for these column on your table
     * @param isNumbers List each column is belong Number or String value
     */
    public CreateTable(ArrayList<String> attributes, ArrayList<Integer> maxSize, ArrayList<Boolean> isNumbers) {
        this.attributes = attributes;
        this.maxSize = maxSize;
        this.isNumbers = isNumbers;
    }

    /**
     * Constructs a CreateTable object with attributes and isNumbers. From that
     * object can calculate ArrayList maxSize
     *
     * @param attributes List of attributes of your table
     * @param isNumbers List each column is belong Number or String value
     */
    public CreateTable(ArrayList<String> attributes, ArrayList<Boolean> isNumbers) {
        this.attributes = attributes;
        this.isNumbers = isNumbers;
        this.getSize();
    }

    private void getSize() {
        for (String str : this.attributes) {
            this.maxSize.add(str.length());
        }
    }

    /**
     * Add new attribute to table format.
     *
     * @param attribute new attribute, this attribute will append to the right
     * of the table
     * @param isNumber a boolean value, show that this attribute is number or
     * not
     */
    public void addAttribute(String attribute, boolean isNumber) {
        this.attributes.add(attribute);
        this.maxSize.add(attribute.length());
        this.isNumbers.add(isNumber);
    }

    /**
     * Add a list of attributes to table format.
     *
     * @param attributes list of attributes
     * @param isNumbers list of isNumbers for each attribute
     */
    public void addAttribute(List<String> attributes, List<Boolean> isNumbers) {
        for (String str : attributes) {
            this.attributes.add(str);
            this.maxSize.add(str.length());
        }
        for (boolean isNumber : isNumbers) {
            this.isNumbers.add(isNumber);
        }
    }

    /**
     * Set size of table based on data of user. Quite complexity, we have a
     * dataSet List contains ArrayLists which is each column. For example we
     * create a table with 3 attribute: id, name, address. We need to create 3
     * arrays represent for each attribute. ArrayList of id, ArrayList of name,
     * ArrayList of address. Add all of into a dataSet List. This method will
     * base on it and set up size for table.
     *
     * @param dataSet A List contains ArrayLists that contains data of each
     * column
     * @return return true if set successfully, and fail if any exception
     * happen.
     */
    public boolean setSizeBaseOnDataset(List<ArrayList<String>> dataSet) {
        if (dataSet.size() != this.attributes.size()) { // if user input false number of collumn
            return false;
        } else { // user input right number of collumn
            for (int i = 0; i < dataSet.size(); i++) {
                List<String> list = dataSet.get(i);
                for (String str : list) {
                    if (str.length() > this.maxSize.get(i)) { //search for max size of strings
                        this.maxSize.set(i, str.length());
                    }
                }
            }
            return true;
        }
    }

    /**
     * Add and set for an attribute specify.
     *
     * @param attribute A new attribute you want to add
     * @param list DataSet of this attribute
     * @param isNumber Is number of not
     */
    public void setAnAttributeSpecify(String attribute, List<String> list, boolean isNumber) {
        this.addAttribute(attribute, isNumber);
        int index = this.maxSize.size() - 1;
        for (String str : list) {
            if (str.length() > this.maxSize.get(index)) { // search for max size of strings
                this.maxSize.set(index, str.length());
            }
        }
    }

    /**
     * Remove an attribute from the table.
     *
     * @param attribute the attribute you want to remove
     * @return true if remove successfully, false if not
     */
    public boolean removeAnAttribute(String attribute) {
        if (this.attributes.indexOf(attribute) != -1) { // if it's value
            int index = this.attributes.indexOf(attribute);
            this.attributes.remove(index);
            this.maxSize.remove(index);
            return true;
        } else { // if it's invalue
            return false;
        }
    }

    /**
     * Remove all attributes in this object.
     */
    public void removeAll() {
        this.attributes.clear();
        this.maxSize.clear();
    }

    /**
     * draw ---
     */
    private void drawBar() {
        for (int i = 0; i < this.attributes.size(); i++) {
            if (i == 0) { // +-----------+------------+------------+
                System.out.print("+-"); 
            } else { // draw only -
                System.out.print("-");
            }
            for (int j = 0; j < this.maxSize.get(i); j++) {
                System.out.print("-");
            }
            System.out.print("-+");
        }
        System.out.println("");
    }
    
    /**
     * draw the title of table
     */
    private void drawHead() {
        for (int i = 0; i < this.attributes.size(); i++) {
            String attr = this.attributes.get(i);
            int size = this.maxSize.get(i);
            if (i == 0) { // draw |
                System.out.print("| ");
            } else { // draw ' '
                System.out.print(" ");
            }                           // | id    |
            System.out.print(attr);
            if (attr.length() < size) { // draw addition ' '
                for (int j = 0; j < size - attr.length(); j++) {
                    System.out.print(" ");
                }
            }
            System.out.print(" |");
        }
        System.out.println("");
    }

    /**
     * draw the body of table
     * @param dataSet list of data
     */
    private void drawBody(List<ArrayList<String>> dataSet) {
        for (int i = 0; i < dataSet.get(0).size(); i++) {
            for (int j = 0; j < this.attributes.size(); j++) {
                String attr = dataSet.get(j).get(i);
                int size = this.maxSize.get(j);
                boolean isNum = this.isNumbers.get(j);
                if (j == 0) { // draw the border
                    System.out.print("| ");
                } else { //draw " "
                    System.out.print(" ");
                }
                if (isNum) {// when value is int
                    if (attr.length() < size) { // addition " "
                        for (int k = 0; k < size - attr.length(); k++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(attr);
                } else { // value is string
                    System.out.print(attr);
                    if (attr.length() < size) { // draw addition ' '
                        for (int k = 0; k < size - attr.length(); k++) {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.print(" |");
            }
            System.out.println("");
        }
    }

    /**
     * First set size for table based on data set before drawTable.
     *
     * @param dataSet A List contains ArrayLists that contains data of each
     * column
     */
    public void drawTable(List<ArrayList<String>> dataSet) {
        this.setSizeBaseOnDataset(dataSet);
        drawBar();
        drawHead();
        drawBar();
        drawBody(dataSet);
        drawBar();
    }
}