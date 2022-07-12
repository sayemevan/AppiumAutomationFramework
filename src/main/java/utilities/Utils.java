package utilities;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.testng.ITestResult;
import register.Data;
import register.Driver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class Utils {

    public void startRecordingScreen() {
        ((CanRecordScreen) Driver.getDriver()).startRecordingScreen();
    }

    public void saveRecordedVideo(ITestResult result) throws IOException {

        String media = ((CanRecordScreen) Driver.getDriver()).stopRecordingScreen();
        if (result.getStatus() == 2) {
            Map<String, String> params;
            params = result.getTestContext().getCurrentXmlTest().getAllParameters();

            String dir = "videos" + File.separator + params.get("platformName") + "_" + params.get("platformVersion") + "_" + params.get(("deviceName")) +
                    File.separator + Data.CURRENT_DATE_TIME + File.separator + result.getTestClass().getRealClass().getSimpleName();

            File videoFile = new File(dir);
            if (!videoFile.exists()) {
                videoFile.mkdirs();
            }

            FileOutputStream stream = new FileOutputStream(videoFile + File.separator + result.getName() + ".mp4");
            stream.write(Base64.getDecoder().decode(media));
        }
    }

    public static String getCurrentDateAndTime(String PatternOfDateTime){
        DateFormat dateFormat = new SimpleDateFormat(PatternOfDateTime);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
