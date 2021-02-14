package pl.coderslab.ut.tddz1;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    private UserRepository userRepository = new UserRepository();

    @Test
    public void shouldCreateUser() {
        // given
        UserRepository userRepository = new UserRepository();
        User user = new User().setUserName("ala");
        // when
        userRepository.create(user);
        // then
        assertEquals(1, user.getId());
        assertEquals("ala", user.getUserName());
        assertEquals(1, userRepository.size());

        User actual2 = userRepository.getById(1);
        assertNotSame(user, actual2);
        assertEquals(user.getId(), actual2.getId());
        assertEquals(user.getUserName(), actual2.getUserName());
    }

    @Test
    public void shouldNotCreateUserWhenHasId() {
        // given
        User user = new User().setId(2).setUserName("ela");
        // when
        userRepository.create(user);
        // then
        assertEquals(2, user.getId());
        assertEquals("ela", user.getUserName());
        assertEquals(0, userRepository.size());
    }

    @Test
    public void shouldNotCreateTwoEntities() {
        // given
        User user1 = new User().setUserName("ela");
        User user2 = new User().setUserName("roman");
        // when
        userRepository.create(user1);
        userRepository.create(user2);
        // then
        assertEquals(2, userRepository.size());

        User actual1 = userRepository.getById(1);
        User actual2 = userRepository.getById(2);

        assertNotSame(user1, actual1);
        assertEquals(user1.getId(), actual1.getId());
        assertEquals(user1.getUserName(), user1.getUserName());

        assertNotSame(user2, actual2);
        assertEquals(user2.getId(), actual2.getId());
        assertEquals(user2.getUserName(), user2.getUserName());
    }

    @Test
    public void shouldUpdate() {
        // given
        User user = new User().setUserName("ela");
        userRepository.create(user);
        final int expectedId = user.getId();
        final String expectedName = "ola";

        // when
        user.setUserName(expectedName);
        userRepository.update(user);

        // then
        assertEquals(1, userRepository.size());
        assertEquals(expectedId, user.getId());
        assertEquals(expectedName, user.getUserName());

        User actual2 = userRepository.getById(1);
        assertNotSame(user, actual2);
        assertEquals(user.getId(), actual2.getId());
        assertEquals(user.getUserName(), actual2.getUserName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenNotManaged() {
        // given
        User user = new User().setId(2).setUserName("ela");

        // when
        userRepository.update(user);

    }

    @Test
    public void shouldDelete() {
        // given
        User user = new User().setUserName("ala");
        userRepository.create(user);

        // when
        userRepository.delete(user);

        // then
        assertEquals(0, userRepository.size());
    }
}