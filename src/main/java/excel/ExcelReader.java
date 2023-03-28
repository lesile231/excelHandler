package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import vo.ResultVO;

public class ExcelReader {


    public void xlsWriter(List<ResultVO> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;

        cell = row.createCell(0);
        cell.setCellValue("아이디");

        cell = row.createCell(1);
        cell.setCellValue("이름");

        cell = row.createCell(2);
        cell.setCellValue("나이");

        cell = row.createCell(3);
        cell.setCellValue("이메일");

        ResultVO result = null;
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            result = list.get(rowIdx);

            row = sheet.createRow(rowIdx+1);

            cell = row.createCell(0);
            cell.setCellValue(result.getCompany_name());

            cell = row.createCell(1);
            cell.setCellValue(result.getCompany_type());

            cell = row.createCell(2);
            cell.setCellValue(result.getCompany_address());

            cell = row.createCell(3);
            cell.setCellValue(result.getCompany_phone_number());

            cell = row.createCell(4);
            cell.setCellValue(result.getCompany_marketing_number());

            cell = row.createCell(5);
            cell.setCellValue(result.getRegistered_date());

            cell = row.createCell(6);
            cell.setCellValue(result.getExpiration_date());

            cell = row.createCell(7);
            cell.setCellValue(result.getRegistration_number());

            cell = row.createCell(8);
            cell.setCellValue(result.getRepresent_name());
        }

        File file = new File("C:\\excel\\testWrite.xls");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(workbook!=null) workbook.close();
                if(fos!=null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public List<ResultVO> readXls(String filePath) {

        List<ResultVO> list = new ArrayList<>();

        FileInputStream fis = null;
        HSSFWorkbook workbook = null;

        try {
            fis= new FileInputStream(filePath);
            workbook = new HSSFWorkbook(fis);

            HSSFSheet curSheet;
            HSSFRow   curRow;
            HSSFCell  curCell;

            ResultVO result;

            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                curSheet = workbook.getSheetAt(sheetIndex);
                for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
                    if(rowIndex != 0) {
                        curRow = curSheet.getRow(rowIndex);
                        result = new ResultVO();
                        String value;

                        if(!"".equals(curRow.getCell(0).getStringCellValue())) {
                            for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                                curCell = curRow.getCell(cellIndex);

                                if(true) {
                                    value = "";
                                    switch (curCell.getCellType()){
                                        case HSSFCell.CELL_TYPE_FORMULA:
                                            value = curCell.getCellFormula();
                                            break;
                                        case HSSFCell.CELL_TYPE_NUMERIC:
                                            value = curCell.getNumericCellValue()+"";
                                            break;
                                        case HSSFCell.CELL_TYPE_STRING:
                                            value = curCell.getStringCellValue()+"";
                                            break;
                                        case HSSFCell.CELL_TYPE_BLANK:
                                            value = curCell.getBooleanCellValue()+"";
                                            break;
                                        case HSSFCell.CELL_TYPE_ERROR:
                                            value = curCell.getErrorCellValue()+"";
                                            break;
                                        default:
                                            value = new String();
                                            break;
                                    }

                                    switch (cellIndex) {
                                        case 0: // 아이디
                                            result.setCompany_type(value);
                                            break;

                                        case 1: // 등록증 번호
                                            result.setRegistration_number(value);
                                            break;

                                        case 2: // 업체명
                                            result.setCompany_name(value);
                                            break;

                                        case 3: // 법인등록번호
                                            if(value != null && value.trim().length() > 0) {
                                                result.setCompany_type("법인");
                                            } else {
                                                result.setCompany_type("개인");
                                            }
                                            break;

                                        case 6: // 등록기간 & 유효기간
                                            if(value != null) {
                                                String[] dates = value.split("~");

                                                result.setRegistered_date(dates[0]);
                                                result.setExpiration_date(dates[1]);
                                            }
                                            break;

                                        case 7: // 대표자 성명
                                            result.setRepresent_name(value);
                                            break;

                                        case 8: // 업체 주소
                                            result.setCompany_address(value);
                                            break;

                                        case 10: // 전화번호
                                            result.setCompany_phone_number(value);
                                            break;

                                        case 11: // 광고용 전화번호
                                            result.setCompany_marketing_number(value);
                                            break;

                                        default:
                                            break;
                                    }
                                }
                            }

                            // cell 탐색 이후 vo 추가
                            list.add(result);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                // 사용한 자원은 finally에서 해제
                if( workbook!= null) workbook.close();
                if( fis!= null) fis.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return list;
    }
}
