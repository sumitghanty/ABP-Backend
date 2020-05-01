package com.mazars.in.report.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import com.mazars.in.reportmodel.AdvanceIMS;
@Component
public class AdvanceMISReport {

	
	//private  Path fileStorageLocation;
	@Value("${pathForReportGeneration}")
	private String path;
	
	List<AdvanceIMS> advanceIMSList=new ArrayList<AdvanceIMS>();
	
	AdvanceIMS a1=new AdvanceIMS();
	AdvanceIMS a2=new AdvanceIMS();
	
	
	
	 public void createAdvanceMISReport(){
		 a1.setTripId("123");
		 a1.setAdjustmentActionBy("samit");
		 a1.setAdvanceAmount("200");
		 a1.setAdvanceRequestedOn("12-04-2020");
		 a1.setApprover("Tiwary");
		 
		 a2.setTripId("123");
		 a2.setAdjustmentActionBy("samit");
		 a2.setAdvanceAmount("200");
		 a2.setAdvanceRequestedOn("12-04-2020");
		 a2.setApprover("Tiwary");
		 
		 advanceIMSList.add(a1);
		 advanceIMSList.add(a2);
		 
		 
		 
		 
		 
		 
		 
	XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Advance IMS");
    CellStyle headerCellStyle3 = workbook.createCellStyle();
	headerCellStyle3.setAlignment(HorizontalAlignment.CENTER);
	XSSFFont font= workbook.createFont();
    font.setFontName("Arial");
    font.setBold(true);
    headerCellStyle3.setFont(font);
    
    
    sheet.setColumnWidth(0, 10000);
	sheet.setColumnWidth(1, 15000);
	sheet.setColumnWidth(2, 5000);
	sheet.setColumnWidth(3, 10000);
	sheet.setColumnWidth(4, 10000);
	sheet.setColumnWidth(5, 10000);
	sheet.setColumnWidth(6, 10000);
	sheet.setColumnWidth(7, 10000);
	sheet.setColumnWidth(8, 10000);
	sheet.setColumnWidth(9, 10000);
	sheet.setColumnWidth(10, 10000);
	sheet.setColumnWidth(11, 10000);
	sheet.setColumnWidth(12, 10000);
	sheet.setColumnWidth(13, 10000);
	sheet.setColumnWidth(14, 10000);
	sheet.setColumnWidth(15, 10000);
	sheet.setColumnWidth(16, 10000);
	sheet.setColumnWidth(17, 10000);
	sheet.setColumnWidth(18, 10000);
	sheet.setColumnWidth(19, 10000);
	sheet.setColumnWidth(20, 10000);
	sheet.setColumnWidth(21, 10000);
	sheet.setColumnWidth(22, 10000);
	
	
	
	
	 Row rowhead = sheet.createRow(0);
     Cell cell ;
     cell =rowhead.createCell(0);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Trip ID"));
     
     cell =rowhead.createCell(1);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Trip Created by"));
     
     cell =rowhead.createCell(2);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Trip Created on"));
     
     cell =rowhead.createCell(3);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Employee Code"));
     
     cell =rowhead.createCell(4);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Employee Name"));
     
     cell =rowhead.createCell(5);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Employee Group"));
     
     cell =rowhead.createCell(6);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Department"));
     
     cell =rowhead.createCell(7);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Work Location"));
     
     cell =rowhead.createCell(8);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Designation"));
     
     
     cell =rowhead.createCell(9);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Approver"));
     
     
     cell =rowhead.createCell(10);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Advance requested on"));
	 
     					

     cell =rowhead.createCell(11);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Advance Approved date"));
     
     cell =rowhead.createCell(12);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Advance amount"));
     
     cell =rowhead.createCell(13);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Trip End date"));
     
     
     cell =rowhead.createCell(14);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Due date for Final adjustment"));
     
     
     cell =rowhead.createCell(15);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Total Reimburseable Amount"));
     
     
     cell =rowhead.createCell(16);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Excess Advance amount"));
    	
     
     					
     
     cell =rowhead.createCell(17);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Type of Adjustment"));
     
     cell =rowhead.createCell(18);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Date of Adjustment settlement"));
     
     
     cell =rowhead.createCell(19);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Financce Approved date"));
     
     
     cell =rowhead.createCell(20);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Number of Installment"));
     
     
     cell =rowhead.createCell(21);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Installment amount"));
     
     
     cell =rowhead.createCell(22);
     cell.setCellStyle(headerCellStyle3);
     cell.setCellValue(new XSSFRichTextString("Adjustment action by"));
     
     for(int i=0;i<advanceIMSList.size();i++) {
    	 
    	 Row row = sheet.createRow(i+1);
    	 
    	cell = row.createCell(0);
		cell.setCellValue(advanceIMSList.get(i).getTripId());
		
		cell = row.createCell(1);
		cell.setCellValue(advanceIMSList.get(i).getTripCreatedBy());
		
		cell = row.createCell(2);
		cell.setCellValue(advanceIMSList.get(i).getTripCreatedOn());
		
		cell = row.createCell(3);
		cell.setCellValue(advanceIMSList.get(i).getEmployeeCode());
		
		cell = row.createCell(4);
		cell.setCellValue(advanceIMSList.get(i).getEmployeeName());
		
		cell = row.createCell(5);
		cell.setCellValue(advanceIMSList.get(i).getEmployeeGroup());
		
		cell = row.createCell(6);
		cell.setCellValue(advanceIMSList.get(i).getDepartment());
		
		cell = row.createCell(7);
		cell.setCellValue(advanceIMSList.get(i).getWorkLocation());
		
		cell = row.createCell(8);
		cell.setCellValue(advanceIMSList.get(i).getDesignation());
		
		cell = row.createCell(9);
		cell.setCellValue(advanceIMSList.get(i).getApprover());
		
		cell = row.createCell(10);
		cell.setCellValue(advanceIMSList.get(i).getAdvanceRequestedOn());
		
		cell = row.createCell(11);
		cell.setCellValue(advanceIMSList.get(i).getAdvanceApprovedDate());
		
		cell = row.createCell(12);
		cell.setCellValue(advanceIMSList.get(i).getAdvanceAmount());
		
		
		cell = row.createCell(13);
		cell.setCellValue(advanceIMSList.get(i).getTripEndDate());
		
		cell = row.createCell(14);
		cell.setCellValue(advanceIMSList.get(i).getDueDateForFinalAdjustment());
		
		cell = row.createCell(15);
		cell.setCellValue(advanceIMSList.get(i).getTotalReimburseableAmount());
		
		cell = row.createCell(16);
		cell.setCellValue(advanceIMSList.get(i).getExcessAdvancceAmount());
		
		cell = row.createCell(17);
		cell.setCellValue(advanceIMSList.get(i).getTypeOfAdjustment());
		
		cell = row.createCell(18);
		cell.setCellValue(advanceIMSList.get(i).getDateOfAdjustmentSettlement());
		
		
		cell = row.createCell(19);
		cell.setCellValue(advanceIMSList.get(i).getFinancceApprovedDate());
		
		
		cell = row.createCell(20);
		cell.setCellValue(advanceIMSList.get(i).getNumberOfInstallment());
		
		cell = row.createCell(21);
		cell.setCellValue(advanceIMSList.get(i).getAdjustmentActionBy());
		
		
		
		
       // workbook.close();
        //System.out.println("Your excel file has been generated in the following location"+PropsUtil.get("fileLocationForTravelToSAPOUT")+"TM_Accounting_Forward.xlsx");

    }

     try
		{
		String path1="advanceMISReport.xlsx";
     File filename = new File(path+path1) ;
     if(filename.exists()) {
     	filename.delete();
     }
     FileOutputStream fileOut = new FileOutputStream(filename);
     workbook.write(fileOut);
     fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
     }
	 
	 
	/* public Resource loadFileAsResourceWithoutZip(
	    		String filePath) {
	        try {
	        	 this.fileStorageLocation = Paths.get(this.fileStorageLocationRoot+"/"+filePath).toAbsolutePath().normalize(); 
	            Path filePath =Paths.get(this.fileStorageLocationRoot+"/"+filePath).resolve(fileName).normalize();
	            String srcPath=filePath.getParent().toString();
	           // String zipPath=filePath.getParent().getParent()+"_"+userId+"_"+tripNo+"_"+lineItem+".zip";
	            if(filePath.getParent().toFile().exists()) {
	            //createZip(srcPath,zipPath);
	            filePath =Paths.get(srcPath).normalize();
	            }else {
	            	
	            }
	            Resource resource = new UrlResource(filePath.toUri());
	            
	            if(resource.exists()) {
	                return resource;
	            } else {
	                throw new Exception("File not found " + fileName);
	            }
	        } catch (MalformedURLException ex) {
	            throw new Exception("File not found " + fileName, ex);
	        }
	    }*/
}
