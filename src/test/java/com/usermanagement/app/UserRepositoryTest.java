package com.usermanagement.app;

import com.usermanagement.app.entiry.User;
import com.usermanagement.app.entiry.UserId;
import com.usermanagement.app.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc
        .AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static com.usermanagement.app.entiry.DateConverter.convertDateToString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class UserRepositoryTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    private ArrayList<User> userList = new ArrayList<>();

    private Date date = new Date(1989, 11, 11);

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        userList.add(new User("TestFN", "TestLN", date, null,
                null));
        userList.add(new User("TestFN1", "TestLN1", date, "1111111111",
                "test1@test.com"));
        userList.add(new User("TestFN2", "TestLN2", date, "1111111112",
                "test2@test.com"));
        userList.add(new User("TestFN3", "TestLN3", date, "1111111113",
                "test3@test.com"));
        userList.add(new User("TestFN4", "TestLN4", date, "1111111114",
                "test4@test.com"));
    }

    @Test
    public void createUserPositiveTest() {
        User user = userList.get(0);
        UserId userId = user.getUserId();
        User addedUser = userRepository.saveAndFlush(user);
        assertThat(userRepository.isUserExist(userId.getFirstName(), userId
                        .getLastName(),
                convertDateToString(userId.getDof())),
                equalTo(1));
        assertThat(addedUser.getEmail(),
                equalTo(user.getEmail()));
        assertThat(addedUser.getPhone(),
                equalTo(user.getPhone()));
    }

    @Test
    public void createUserPositiveTest1() {
        User user = userList.get(1);
        UserId userId = user.getUserId();
        userRepository.saveAndFlush(user);
        User addedUser = userRepository.findByName(userId.getFirstName(),
                userId.getLastName(), userId.getDof());
        assertThat(userRepository.isUserExist(userId.getFirstName(), userId
                        .getLastName(),
                convertDateToString(userId.getDof())),
                equalTo(1));
        assertThat(addedUser.getEmail(),
                equalTo(user.getEmail()));
        assertThat(addedUser.getPhone(),
                equalTo(user.getPhone()));
    }

    @Test
    public void updateUserPositiveTest1() {
        User user = userList.get(2);
        UserId userId = user.getUserId();
        userRepository.saveAndFlush(user);
        long id = userRepository.findByName(userId.getFirstName(), userId
                .getLastName(), userId.getDof()).getId();
        userRepository.updateUserInfo("test2@test2.com", "1111111123", id);
        assertThat(userRepository.findById(id).get().getPhone(), equalTo
                ("1111111123"));
        assertThat(userRepository.findById(id).get().getEmail(), equalTo
                ("test2@test2.com"));
    }

    @Test
    public void deleteUser() {
        User user = userList.get(3);
        UserId userId = user.getUserId();
        userRepository.delete(user);
        assertThat(userRepository.isUserExist(userId.getFirstName(), userId
                        .getLastName(),
                convertDateToString(userId.getDof())),
                equalTo(0));
    }

    @After
    public void dearDown() {
       userRepository.deleteAll();
    }
}
