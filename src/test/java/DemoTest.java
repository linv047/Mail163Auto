import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import util.ExcelUtil;

/**
 * Created by lenovo on 2017/9/11.
 */
public class DemoTest {

    @Test
    public void test163Mail(){
        String str = null;
       if(null==str){
           System.out.println("this is null");
       }else {
           System.out.println("not null");
       }
    }
    @Test
    public void testExcelUtil() throws Exception {
        ExcelUtil.setExcelFile("D:\\test.xlsx","Sheet1");
        System.out.println(ExcelUtil.getCellData(1,2));
    }

    @Test
    public void testExcelUtil2() throws Exception {
        //ExcelUtil.setExcelFile("D:\\test.xlsx","Sheet1");
        Object[][] result = ExcelUtil.getTestData("D:\\test.xlsx","Sheet1");

        for (int i=0;i<result.length;i++){
            for (int j=0;j<result[i].length;j++){
                System.out.print(result[i][j]+"   ");
            }
            System.out.println();
        }

    }

}
