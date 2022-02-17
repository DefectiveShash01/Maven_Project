package com.athenahealth.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Methodsofapp {
		String SAMPLE_XLSX_FILE_PATH = "C:/Users/saryan/Documents/Book1.xlsx";
		Data arr[];
		int n=0;
		Workbook wb;
		Sheet sheet;
			
		public void load() throws IOException {
			this.wb = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
			this.sheet = wb.getSheetAt(0);
	        Iterator<Row> rowIterator1 = sheet.rowIterator();
	        while (rowIterator1.hasNext()) {
	            rowIterator1.next();
	            n++;
	        }
	        arr=new Data[n-1];
			DataFormatter dataFormatter = new DataFormatter();
	        Sheet sheet = wb.getSheetAt(0);
	        Iterator<Row> rowIterator = sheet.rowIterator();
	        rowIterator.next();
	        int i;
	        for(int j=1;j<=n;j++){
	        	if(!rowIterator.hasNext()) {
	        		break;
	        	}
	            Row row = rowIterator.next();
	            Iterator<Cell> cellIterator = row.cellIterator();
	            i=0;
	            String cellValue[]=new String[row.getLastCellNum()-row.getFirstCellNum()];
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                cellValue[i] = dataFormatter.formatCellValue(cell).toString();
	                i++;
	            }
	            arr[j-1]=new Data(cellValue[0], cellValue[1], cellValue[2]);
	        }
	        
		}
		public void record() {
			
			format();
	        for(int i=0;i<n-1;i++) {
	        	arr[i].display();
	        	System.out.println();
	        }
		}
		public void nameRecord(String s) {
			format();
			boolean a=true;
	        for(int i=0;i<n-1;i++) {
	        	if(arr[i].name.equals(s)) {
	        		arr[i].display();
	        		System.out.println();
	            	a=false;
	            	break;
	        	}
	        }
	        if(a) {
	        	System.out.println("No Data Record found");
	        }
		}
		
		public void regRecord(String re) {
			format();
			int abc=Integer.parseInt(re);
			boolean a=true;
	        for(int i=0;i<n-1;i++) {
	        	if(arr[i].RegNo==abc) {
	        		arr[i].display();
	        		System.out.println();
	            	a=false;
	            	break;
	        	}
	        }
	        if(a) {
	        	System.out.println("No Data Record found");
	        }
		}

		public void checkMarks() {
			format();
			
			for(int i=0;i<arr.length;i++) {
	        	arr[i].display();
	        	if(arr[i].marks>=40.0) {
	        		System.out.print("Pass");
	        	}
	        	else {
	        		System.out.print("Fail");
	        	}
	        	System.out.println();
	        }
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
		public void sort(int option) {
			
			List<Data> list = new ArrayList<>(Arrays.asList(arr));
			int op = option;
			switch(op) {
			case 1:Collections.sort(list, new Sbr());
					break;
			case 2:Collections.sort(list, new Sbs());
					break;
			case 3:Collections.sort(list, new Sbm());
					break;
			default:System.out.println("Enter a Valid Option");
				
			}
			format();
			for (int i = 0; i < list.size(); i++)
	            System.out.println(list.get(i).RegNo + "||"+list.get(i).name + "||"+list.get(i).marks);
	    }
			
		
		
		public void addStudent(String [] s1) {
		      sheet.createRow(n);
		      Row row=sheet.getRow(n);
		      int i=0;
		      for(i=0;i<s1.length;i++) {
		    		Cell cell = row.createCell(i);
		            cell.setCellValue(s1[i]);
		      }
		        try {
		        FileOutputStream outputStream = new FileOutputStream(new File("C:/Users/saryan/Documents/Book4.xlsx"));
		        wb.write(outputStream);
		        n=n+1;
		        System.out.println("Success");
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
		    }
		
		}
		
		
	

