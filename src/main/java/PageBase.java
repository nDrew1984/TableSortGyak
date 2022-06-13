import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    private final String url = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    private final By searchBox = By.xpath("//*[@id=\"example_filter\"]/label/input");
    private final By table = By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]");

    public void navigate() {
        driver.get(url);
    }

    public void search(String s) {
        WebElement e = driver.findElement(searchBox);
        e.sendKeys(s);
    }

    public String[] readTable() {
        List<WebElement> cells = driver.findElements(table);
        String[] names = new String[cells.size()];
        for (int i = 0; i < cells.size(); i++) {
            names[i] = cells.get(i).getText();
        }
        return names;
    }

}
