package Utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Screenshots{
    public static void takeScreenshot(WebDriver driver, String testCaseName, WebElement element)
            throws IOException, IOException {
        // Cast driver object to TakesScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        try {
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(srcFile);
            Point point = element.getLocation();
            int eleWidth = element.getSize().getWidth();
            int eleHeight = element.getSize().getHeight();
            Graphics2D graphics = fullImg.createGraphics();
            graphics.setColor(Color.RED);
            graphics.setStroke(new BasicStroke(4));
            graphics.drawRect(point.getX(), point.getY(), eleWidth, eleHeight);
            graphics.dispose();
            String directoryPath = System.getProperty("user.dir") + "/ScreenshotUtils/";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                boolean isDirectoryCreated = directory.mkdirs();
                if (!isDirectoryCreated) {
                    System.out.println("Failed to create directory for screenshots.");
                    return;
                }
            }
            File destFile = new File(directoryPath + testCaseName + ".png");

            ImageIO.write(fullImg, "png", destFile);

            byte[] fileContent = FileUtils.readFileToByteArray(destFile);
            Allure.addAttachment(testCaseName, new ByteArrayInputStream(fileContent));

            System.out.println("Screenshot taken for test case: " + testCaseName);
        } catch (IOException e) {
            System.out.println("An error occurred while taking screenshot: " + e.getMessage());
        }
    }
}
