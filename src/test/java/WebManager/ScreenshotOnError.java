package WebManager;



import com.freecrm.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenshotOnError extends BaseClass {

    public static void faliure(){

        System.out.println("  on Failure");

        LocalDateTime dt= LocalDateTime.now();

        String dt1= dt.toString();

      File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(srcfile, new File("C:\\Users\\DANISH\\IdeaProjects" + "error" + ".png" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
