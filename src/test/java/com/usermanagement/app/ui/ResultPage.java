package com.usermanagement.app.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class ResultPage extends AbstractPage {

    @FindBy(id = "result_header")
    private HtmlElement resultPageHeader;

    public ResultPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 60);
    }

    public boolean checkIfPageOpen() {
        return isPageOpen(resultPageHeader);
    }
}
