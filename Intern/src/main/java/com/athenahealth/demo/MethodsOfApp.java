package com.athenahealth.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MethodsOfApp {
	String SAMPLE_XLSX_FILE_PATH = "C:/Users/saryan/Documents/Book1.xlsx";
	ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
	int n=0;
	FileInputStream inputStream;
	Workbook wb;
	Sheet sheet;
	public void load() throws IOException {
		this.inputStream = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
		this.wb = WorkbookFactory.create(inputStream);
		this.sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator1 = sheet.rowIterator();
        while (rowIterator1.hasNext()) {
            rowIterator1.next();
            n++;
        }
		DataFormatter dataFormatter = new DataFormatter();
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();
        for(int j=1;j<=n;j++){
        	if(!rowIterator.hasNext()) {
        		break;
        	}
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i=0;
            ArrayList<String> cellValue = new ArrayList<String>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cellValue.add(dataFormatter.formatCellValue(cell).toString());
                i++;
            }
           
            arr.add(cellValue);
        }
        
	}
	public ArrayList<ArrayList<String>> record() {
		
		return arr;
	}
	public List<String> nameRecord(String s) throws Exception {
		List<String> names=new ArrayList<String>();
		boolean a=true;
        for(int i=0;i<n-1;i++) {
        	if(arr.get(i).get(1).equals(s)) {
        		names= arr.get(i);
            	a=false;
            	break;
        	}
        }
        if(a) {
        	throw new RecordNotFoundException("No Data Record found for Name Search");
        }
        return names;
	}
	
	public List<String> regRecord(String re) throws Exception{
		List<String> regs=new ArrayList<String>();
		//format();
		boolean a=true;
        for(int i=0;i<n-1;i++) {
        	if(Integer.parseInt(arr.get(i).get(0))==Integer.parseInt(re)) {
        		regs= arr.get(i);
            	a=false;
            	break;
        	}
        }
        if(a) {
        	throw new RecordNotFoundException("No Data Record found for Registration number search");
        }
        return regs;
	}

	public ArrayList<ArrayList<String>> checkMarks() {
		ArrayList<ArrayList<String>> cm = new ArrayList<ArrayList<String>>();
		
		for(int i=0;i<arr.size();i++) {
			ArrayList<String> cell = new ArrayList<String>();
        	for(int j=0;j<arr.get(i).size();j++) {
        		cell.add(arr.get(i).get(j));
        	}
        	if(Double.parseDouble(arr.get(i).get(2))>=40.0) {
        		cell.add("Pass");
        	}
        	else {
        		cell.add("Fail");
        	}
        	cm.add(cell);
        }
		return cm;
	}
	public void format() {
		DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        if(rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
    		Cell cell = cellIterator.next();
    		String cellValue = dataFormatter.formatCellValue(cell);
    		System.out.print(cellValue + "||");
    	}
        System.out.println();
        }
	}
	public ArrayList<ArrayList<String>> sort(String option) {
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		list=arr;
		final int op = Integer.parseInt(option);
		Collections.sort(list, new Comparator<ArrayList<String>>(){
			@Override
	        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
	            return o1.get(op).compareTo(o2.get(op));
	        }
		});
		return list;
            
    }
		
	
	
	public void addStudent(ArrayList<String> s1) throws EncryptedDocumentException, IOException {
		  sheet.createRow(n);
		  Row row=sheet.getRow(n);
		  int i=0;
		  for(i=0;i<s1.size();i++) {
				Cell cell = row.createCell(i);
		        cell.setCellValue(s1.get(i));
		  }
		  
		    try {
		    	this.inputStream.close();
		    	FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/saryan/Documents/Book1.xlsx"));
				wb.write(outputStream);
				n=n+1;
		    }
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		    try {
		    	arr.clear();
				load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
