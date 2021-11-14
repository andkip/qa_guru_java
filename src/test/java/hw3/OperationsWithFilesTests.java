package hw3;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsWithFilesTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
    }

    @DisplayName("Проверка значения в txt файле, далее конвертация в pdf на сайте и проверка что наше значение есть в pdf файле")
    @Test
    public void uploadTXTConvertToPDFCheckValueTest() throws IOException {
        String fileText = "hello";
        String everything = IOUtils.toString(new FileReader("src/test/resources/hello.txt"));
        assertTrue(everything.contains(fileText));
        open("https://www.freepdfconvert.com/ru");
        $("[type=file]").uploadFromClasspath("hello.txt");
        File pdfConverted = $(".btn-wrapper.download-btn").download();
        PDF parsedPdf = new PDF(pdfConverted);
        String hasText = parsedPdf.text;
        assertTrue(hasText.contains(fileText), "Актуальное значение не соответсвует ожидаемому");
    }

    @DisplayName("Сверка значения ячейки XLS файла распакованного из ZIP архива с сайта Antrek")
    @Test
    public void recognizeTextInXlsFromZip() throws IOException {
        open("http://antrek.ru/content/price");
        File downloadedZip = $(byText("antrek-price.zip")).download();
        String zipFilePath = downloadedZip.getPath();
        try (InputStream is = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();
                FileOutputStream fout = new FileOutputStream("build/downloads/" + name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();

                File xls = new File("build/downloads/" + name);
                XLS parsedXls = new XLS(xls);
                String expectedValue = "Прайс-лист";
                String actualValue = parsedXls.excel
                        .getSheetAt(0)
                        .getRow(4)
                        .getCell(1)
                        .getStringCellValue();
                assertEquals(expectedValue, actualValue, "Актуальное значение не соответсвует ожидаемому");
            }
        }
    }
}
