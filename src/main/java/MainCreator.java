import excel.ExcelReader;
import java.util.List;
import vo.ResultVO;

public class MainCreator {
    public static void main(String[] args) {

        try {
            ExcelReader reader = new ExcelReader();

            List<ResultVO> resultList = reader.readXls("C:\\Users\\user\\Documents\\test\\new.xls");

            resultList.sort((a, b) -> {
                if(a.getEpoch() > b.getEpoch()) {
                    return -1;
                } else if (a.getEpoch() < b.getEpoch()) {
                    return 1;
                }

                return 0;
            });

            //resultList.forEach((result) -> { System.out.println("result >>> " + result); } );
            reader.xlsWriter(resultList);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
