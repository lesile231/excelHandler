import excel.ExcelReader;
import java.util.List;
import vo.ResultVO;

public class MainCreator {
    public static void main(String[] args) {

        ExcelReader reader = new ExcelReader();

        List<ResultVO> resultList = reader.readXls("C:\\Users\\LEE_SANGIL03\\Downloads\\20230328_lenders1.xls");

        resultList.forEach((result) -> { System.out.println("result >>> " + result); } );
    }
}
