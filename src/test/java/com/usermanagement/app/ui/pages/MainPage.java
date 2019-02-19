package com.usermanagement.app.ui.pages;

import com.usermanagement.app.ui.blocks.AddUserBlock;
import com.usermanagement.app.ui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class MainPage extends AbstractPage {

    private AddUserBlock userBlock;

    @FindBy(id = "header")
    private HtmlElement mainPageHeader;

    public MainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 60);
    }

    public boolean checkIfPageOpen() {
        return isPageOpen(mainPageHeader);
    }

    public void addUser(String firstName, String lastName, String dob, String
            email, String phone) {
        userBlock.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterDOB(dob)
                .enterEmail(email)
                .enterPhone(phone)
                .clickSubmitButton();
    }
}

