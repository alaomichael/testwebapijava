package com.sigmaoct.testwebapi.service;

import com.sigmaoct.testwebapi.persistence.User;
import static org.junit.jupiter.api.Assertions.*;

import com.sigmaoct.testwebapi.repository.UserRepository;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
public class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    JdbcTemplate jdbc;

    @BeforeAll
    public static void setUpClass(){
        System.out.println("in setup before all");
    }

    @AfterAll
    public  static  void tearDownClass(){
        System.out.println("in teardown after all");
    }

    @BeforeEach
    public void setUp(){
        //System.out.println("populating record in user table before each");
        jdbc.execute("insert into userprofile(id, name) " +
                "values ('1', 'Mike'), ('2', 'Dammy')");

    }

    @AfterEach
    public void tearDown(){
        //System.out.println("truncating user table after each");
        jdbc.execute("TRUNCATE TABLE userprofile");
    }

    @Test
    public void testCreateUser (){

        //test user creation
        User user = new User();
        user.setId("10");
        user.setName("Tomiwa");

        when(userRepository.save(user)).thenReturn(new User("10", "Tomiwa"));
        User expectedUser = userService.create(user);
        assertEquals(user, expectedUser, "User Tomiwa is expected");
    }

    @Test
    public void testListUser (){
        List<User> expectedUsers = userService.list();
        assertEquals(2, expectedUsers.size(), "two user are expected");
    }
}
