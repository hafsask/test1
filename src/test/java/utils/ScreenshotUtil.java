package utils;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotUtil {


    public static void takeScreenshot(WebDriver driver,String scenarioName){

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = "screenshots/" +scenarioName+ "_" +timestamp+ ".png";
        try{
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
