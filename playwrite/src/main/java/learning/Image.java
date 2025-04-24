package learning;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import com.asprise.ocr.Ocr;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Image {

	public static void main(String[] args) throws TesseractException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		Page page = browser.newPage();
		page.navigate("https://produi-ecare.mightcode.com");
		page.locator("//*[@id='canv']").first().screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshot/captcha.png")));
		
		String path = "/home/unicode/Downloads/Playwrite/playwrite/Screenshot/captcha.png";
		ITesseract image = new Tesseract();

		String str = image.doOCR(new File(path));
		System.out.println("Image ocr is done");
		System.out.println(str);

	}

}
