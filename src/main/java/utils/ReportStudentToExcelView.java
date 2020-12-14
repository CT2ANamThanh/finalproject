package utils;

import entity.StudentEntity;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class ReportStudentToExcelView extends AbstractXlsxView {

    @Override
    public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-exported-file.xls\"");

        @SuppressWarnings("unchecked")
        List<StudentEntity> student = (List<StudentEntity>) model.get("student");
        
        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Report List");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");

        //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //font.setBold(true);
        style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("First Name");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Last Name");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Address");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Email");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Phone");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Birth Date");
        header.getCell(6).setCellValue("Birth Date");  
        header.createCell(7).setCellValue("Start Date");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("End Date");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Sex");
        header.getCell(9).setCellStyle(style);

        int rowCount = 1;
        for (StudentEntity student1 : student) {
            Row studentRow = sheet.createRow(rowCount++);
            studentRow.createCell(0).setCellValue(student1.getId());
            studentRow.createCell(1).setCellValue(student1.getFirstName());
            studentRow.createCell(2).setCellValue(student1.getLastName());
            studentRow.createCell(3).setCellValue(student1.getAddress());
            studentRow.createCell(4).setCellValue(student1.getEmail());
            studentRow.createCell(5).setCellValue(student1.getPhone());
            
            Date birthDate = java.sql.Date.valueOf(student1.getBirthDate());
            studentRow.createCell(6).setCellValue(birthDate.toString());
            
            Date startDate = java.sql.Date.valueOf(student1.getStartDate());
            studentRow.createCell(7).setCellValue(startDate.toString());
            
            Date endDate = java.sql.Date.valueOf(student1.getStartDate());
            studentRow.createCell(8).setCellValue(endDate.toString());
            
            studentRow.createCell(9).setCellValue(student1.getSex());
        }

    }
    
}
