/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.hssf.record.OldFormulaRecord;
import org.apache.poi.ss.usermodel.CellType;
import java.lang.Object;
import org.apache.poi.ss.usermodel.CellValue;

/**
 *
 * @author liudas
 */
public class dataExtractor {
    
    
    
    
    public static final String DELIM = "\t";
    private double supplierName;
    private String supplierCategory;
    private String item;
    private double orderDate;
    private double plannedDeliveryDate;
    private double actualDeliveryDate;
    private double late;
    private double early;
    private double tardy;
    private String status;
    
    public dataExtractor()
    {
          this.supplierCategory = this.item = this.status = "none";
         this.actualDeliveryDate = this.orderDate = this.plannedDeliveryDate = this.supplierName = this.late = this.early = this.tardy = 0.0;
    }
    public dataExtractor(double aSupplierName, String aSupplierCategory, String aItem,
                         double aOrderDate, double aPlannedDeliveryDate, double aActualDeliveryDate,
                         double aLate, double aEarly, double aTardy, String aStatus)
    {
        this.setSupplierName(aSupplierName);
        this.setActualDeliveryDate(aActualDeliveryDate);
        this.setEarly(aEarly);
        this.setItem(aItem);
        this.setOrderDate(aOrderDate);
        this.setStatus(aStatus);
        this.setLate(aLate);
        this.setTardy(aTardy);
        this.setPlannedDeliveryDate(aPlannedDeliveryDate);
        this.setSupplierCategory(aSupplierCategory);
    }

    public double getSupplierName() {
        return supplierName;
    }

    public String getSupplierCategory() {
        return supplierCategory;
    }

    public String getItem() {
        return item;
    }

    public double getLate() {
        return orderDate;
    }

    public double getPlannedDeliveryDate() {
        return plannedDeliveryDate;
    }

    public double getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public double getOrderDate() {
        return late;
    }

    public double getEarly() {
        return early;
    }

    public double getTardy() {
        return tardy;
    }

    public String getStatus() {
        return status;
    }

    public void setSupplierName(double supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierCategory(String supplierCategory) {
        this.supplierCategory = supplierCategory;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setOrderDate(double orderDate) {
        this.orderDate = orderDate;
    }

    public void setPlannedDeliveryDate(double plannedDeliveryDate) {
        this.plannedDeliveryDate = plannedDeliveryDate;
    }

    public void setActualDeliveryDate(double actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public void setLate(double late) {
        this.late = late;
    }

    public void setEarly(double early) {
        this.early = early;
    }

    public void setTardy(double tardy) {
        this.tardy = tardy;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   /*
    private Object getCellValue(Cell nextCell) {
        if (nextCell.getCellTypeEnum() == CellType.NUMERIC)
                {
                  nextCell.getNumericCellValue();
                }
                if (nextCell.getCellTypeEnum() == CellType.STRING)
                {
                     nextCell.getStringCellValue();
                

                        switch (nextCell.getCellType()) {

                        case XSSFCell.CELL_TYPE_FORMULA:
                            // Get the type of Formula
                            switch (nextCell.getCachedFormulaResultType()){
                            case HSSFCell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value = cell.getNumericCellValue()+"";
                                break;
                                default:
                            }
                            break;
    }
    }
*/
    ArrayList<dataExtractor> supply = new ArrayList<>();
    public ArrayList<dataExtractor> readFromFile() throws IOException 
    {
        String file = SupplyChain.getInstance().getFile().toString();
       
        FileInputStream inputStream = new FileInputStream(new File(file));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
       
        iterator.next();
        
        while (iterator.hasNext())
        {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            
            dataExtractor aDataExtractor = new dataExtractor();
           
            
            while (cellIterator.hasNext())
            {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                
                 CellValue cellValue = evaluator.evaluate(nextCell);
                 // System.out.println(cellValue.formatAsString());
              
              
              
               switch(columnIndex)
                {
                    case 0:
                         
                        aDataExtractor.setSupplierName(cellValue.getNumberValue());
                        
                        break;
                    case 1:
                        aDataExtractor.setSupplierCategory(cellValue.getStringValue());
                        break;
                    case 2:
                        aDataExtractor.setItem(cellValue.getStringValue());
                        break;
                    case 3:
                        aDataExtractor.setOrderDate(cellValue.getNumberValue());
                        break;
                    case 4:
                        aDataExtractor.setPlannedDeliveryDate(cellValue.getNumberValue());
                        break;
                    case 5:
                        aDataExtractor.setActualDeliveryDate(cellValue.getNumberValue());
                        break;
                    case 6:
                        aDataExtractor.setLate(cellValue.getNumberValue());
                       // System.out.println(Integer.toString((Integer) getCellValue(nextCell)));
                        break;
                        
                    case 7:
                        aDataExtractor.setEarly(cellValue.getNumberValue());
                        break;
                    case 8:
                        aDataExtractor.setTardy(cellValue.getNumberValue());
                        break;
                    case 9:
                        aDataExtractor.setStatus(cellValue.getStringValue());
                        break;
                }
                
            }
            supply.add(aDataExtractor);
        }
        workbook.close();
        inputStream.close();
        return supply;
       
    }
    public ArrayList<dataExtractor> getData()
    {
        return this.supply;
    }
    
    
    

    public ObservableList<Double> supplierNames(ArrayList<dataExtractor> supply)
    {
        ObservableList<Double> options = FXCollections.observableArrayList();
        for(int i = 0; i< supply.size(); i++)
        {
            if (!options.contains(supply.get(i).getSupplierName()) || options == null)
            {
                options.add(supply.get(i).getSupplierName());
                
               
            }
        }
        return options;
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
        try
        {
            Scanner fileScanner = new Scanner(SupplyChain.getInstance().getFile());
            System.out.println(SupplyChain.getInstance().getFile());
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                String[] splitStrings = fileLine.split(DELIM);
                String supplierName = splitStrings[0];
                System.out.println(supplierName);
                
                String supplierCategory = splitStrings[1];
                String item = splitStrings[2];
                String orderDate = splitStrings[3];
                String plannedDeliveryDate = splitStrings[4];
                String actualDeliveryDate = splitStrings[5];
                int late = Integer.parseInt(splitStrings[6]);
                int early = Integer.parseInt(splitStrings[7]);
                int tardy = Integer.parseInt(splitStrings[8]);
                String status = splitStrings[9];
                dataExtractor supplier = new dataExtractor(supplierName, supplierCategory, item, orderDate,
                    plannedDeliveryDate, actualDeliveryDate, late, early, tardy, status);
                supply.add(supplier);
                System.out.println(supply.get(4));
                
           }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    
    
    
   static ArrayList<String> list = new ArrayList<String>(); 
    public static void loadData()
    {
        try
        {
            Scanner fileScanner = new Scanner(SupplyChain.getInstance().getFile());
            while(fileScanner.hasNextLine())
            {
                list.add(fileScanner.nextLine());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void printData(String fileName, boolean append)
    {
        try
	{
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append));
            for (int i = 0; i<supply.size(); i++)
            {
                fileWriter.println(supply.get(i).getSupplierName() + DELIM +
                        supply.get(i).getActualDeliveryDate() + DELIM +
                        supply.get(i).getSupplierCategory() + DELIM +
                        supply.get(i).getStatus() + DELIM +
                        supply.get(i).getPlannedDeliveryDate() + DELIM + 
                        supply.get(i).getEarly() + DELIM +
                        supply.get(i).getLate());
            }
           
             fileWriter.close();
        }
       
        catch(Exception e)
	{
            System.out.println(e);
	}        
    }
    

*/

}
