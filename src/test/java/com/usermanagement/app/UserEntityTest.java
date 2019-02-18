package com.usermanagement.app;

import com.usermanagement.app.model.User;
import com.usermanagement.app.model.UserId;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc
        .AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class UserEntityTest {

    private ArrayList<User> userList = new ArrayList<>();

    private Date date = new Date(1990, 11, 11);

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Before
    public void setUp() {
            userList.add(new User("TestFN", "TestLN", date, "1111111111",
                    "test@test.com"));
            userList.add(new User("TestFN1", "TestLN1", date, "1111111112",
                    null));
            userList.add(new User("TestFN2", "TestLN2", date, null,
                    "test2@test.com"));
            userList.add(new User("TestFN3", "TestLN3", date, null,
                    null));
            userList.add(new User("TestFN4", "TestLN4", date, "1111111114",
                    "test4@test.com"));
    }

    @Test
    public void createUserPositiveTest1() {
        User user = userList.get(0);
        UserId userId = user.getUserId();
        assertThat(userId.getFirstName(), equalTo("TestFN"));
        assertThat(userId.getLastName(), equalTo("TestLN"));
        assertThat(userId.getDof(), equalTo(date));
        assertThat(user.getPhone(), equalTo("1111111111"));
        assertThat(user.getEmail(), equalTo("test@test.com"));
    }

    @Test
    public void createUserPositiveTest2() {
        User user = userList.get(1);
        UserId userId = user.getUserId();
        assertThat(userId.getFirstName(), equalTo("TestFN1"));
        assertThat(userId.getLastName(), equalTo("TestLN1"));
        assertThat(userId.getDof(), equalTo(date));
        assertThat(user.getPhone(), equalTo("1111111112"));
        assertThat(user.getEmail(), equalTo(null));
    }

    @Test
    public void createUserPositiveTest3() {
        User user = userList.get(2);
        UserId userId = user.getUserId();
        assertThat(userId.getFirstName(), equalTo("TestFN2"));
        assertThat(userId.getLastName(), equalTo("TestLN2"));
        assertThat(userId.getDof(), equalTo(date));
        assertThat(user.getEmail(), equalTo("test2@test.com"));
        assertThat(user.getPhone(), equalTo(null));
    }

    @Test
    public void createUserPositiveTest4() {
        User user = userList.get(3);
        UserId userId = user.getUserId();
        assertThat(userId.getFirstName(), equalTo("TestFN3"));
        assertThat(userId.getLastName(), equalTo("TestLN3"));
        assertThat(userId.getDof(), equalTo(date));
        assertThat(user.getEmail(), equalTo(null));
        assertThat(user.getPhone(), equalTo(null));
    }

    @Test
    public void createUserNegativeTest1() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        User user = new User(null, "TestLN", date, "1111111111",
                "test@test.com");
    }

    @Test
    public void createUserNegativeTest2() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        User user = new User("TestFN", null, date, "1111111111",
                "test@test.com");
    }
}
