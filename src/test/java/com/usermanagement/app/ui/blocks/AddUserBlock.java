package com.usermanagement.app.ui.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Add user form")
@Block(@FindBy(name = "add_user"))
public class AddUserBlock extends HtmlElement {

    @FindBy(name = "firstName")
    private TextInput firstNameField;

    @FindBy(name = "lastName")
    private TextInput lastNameField;

    @FindBy(name = "email")
    private TextInput emailField;

    @FindBy(name = "phone")
    private TextInput phoneField;

    @FindBy(name = "dob")
    private TextInput dobField;

    @FindBy(xpath = "//button[@type='submit']")
    private Button submitButton;

    public AddUserBlock enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public AddUserBlock enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public AddUserBlock enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public AddUserBlock enterPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    public AddUserBlock enterDOB(String dob) {
        dobField.sendKeys(dob);
        return this;
    }

    public AddUserBlock clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
