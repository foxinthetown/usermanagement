package com.usermanagement.app;

import com.usermanagement.app.repository.UserRepository;
import com.usermanagement.app.ui.AbstractUiTest;
import com.usermanagement.app.ui.pages.MainPage;
import com.usermanagement.app.ui.pages.ResultPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc
        .AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddUserE2ETest extends AbstractUiTest {

    private MainPage mainPage = new MainPage(driver);

    private ResultPage resultPage = new ResultPage(driver);

    @Autowired
    private UserRepository userRepository;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        openPage("http://localhost:" + port);
    }

    @Test
    public void addUserTest() {
        mainPage.checkIfPageOpen();
        mainPage.addUser("UiFirstName", "UiLastName", "02/12/1989",
                "uiemail@test.com", "1233435435");
        assertThat(resultPage.checkIfPageOpen(), is(true));
        assertThat(userRepository.isUserExist("UiFirstName", "UiLastName",
                "1989-02-12"),
                equalTo(1));
    }

    @After
    public void closeDriver() {
        userRepository.deleteAll();
        driver.quit();
    }
}
