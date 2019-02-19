package com.usermanagement.app.ui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

class AbstractPage {

    WebDriverWait wait;

    boolean isPageOpen(HtmlElement element) {
        wait.until(ExpectedConditions.visibilityOf(element.getWrappedElement
                ()));
        return element.isDisplayed();
    }
}
