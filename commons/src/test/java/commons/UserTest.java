package commons;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    /**
     * A Test to check the constructor of the User class
     */
    @Test
    public void checkConstructor() {
        User testUser = new User(1, "username", "email");
        assertNotNull(testUser);
        assertEquals(1, testUser.getId());
        assertEquals("username", testUser.getUsername());
        assertEquals("email", testUser.getEmail());
        assertEquals("english", testUser.getDisplayLanguage());
        assertEquals(new ArrayList<Event>(), testUser.getParticipatingEvents());
    }

    /**
     * A Test to check the empty constructor of the User class
     */
    @Test
    public void testEmptyConstructor() {
        User testUser = new User();
        assertNotNull(testUser);
    }

    /**
     * A Test to check the getters and setters of the User class
     */
    @Test
    public void testGetId() {
        User testUser = new User(1, "username", "email");
        assertEquals(1, testUser.getId());
    }

    /**
     * A Test to check the getters and setters of the User class
     */
    @Test
    public void testGetUsername() {
        User testUser = new User(1, "username", "email");
        assertEquals("username", testUser.getUsername());
    }

    /**
     * A Test to check the getters and setters of the User class
     */
    @Test
    public void testGetEmail() {
        User testUser = new User(1, "username", "email");
        assertEquals("email", testUser.getEmail());
    }

    /**
     * A Test to check the getters and setters of the User class
     */
    @Test
    public void testGetParticipant() {
        User testUser = new User(1, "username", "email");
        assertEquals("english", testUser.getDisplayLanguage());
    }

    /**
     * A Test to check the getters and setters of the User class
     */
    @Test
    public void testGetParticipatingEvents() {
        User testUser = new User(1, "username", "email");
        assertEquals(new ArrayList<Event>(), testUser.getParticipatingEvents());
    }
    
    /**
     * Testing the id setter
     */
    @Test
    public void testSetId() {
        User testUser = new User(1, "username", "email");
        testUser.setId(4);
        assertEquals(4, testUser.getId());
    }
    
    /**
     * Testing the username setter
     */
    @Test
    public void testSetUsername() {
        User testUser = new User(1, "username", "email");
        testUser.setUsername("another");
        assertEquals("another", testUser.getUsername());
    }
    
    /**
     * Testing the email setter
     */
    @Test
    public void testSetEmail() {
        User testUser = new User(1, "username", "email");
        testUser.setEmail("newmail");
        assertEquals("newmail", testUser.getEmail());
    }

    /**
     * Test to ensure setting the display language of the user works correctly
     */
    @Test
    public void testSetDisplayLanguage() {
        User testUser = new User(1, "username", "email");
        testUser.setDisplayLanguage("dutch");
        assertEquals("dutch", testUser.getDisplayLanguage());
    }

    /**
     * Test to ensure setting the events of the user works correctly
     */
    @Test
    public void testSetParticipatingEvents() {
        Event event1 = new Event();
        Event event2 = new Event();
        List<Event> events = List.of(event1, event2);
        User testUser = new User(1, "username", "email");
        testUser.setParticipatingEvents(events);
        assertEquals(events, testUser.getParticipatingEvents());
    }

    /**
     * testing that adding events works correctly
     */
    @Test
    public void testAddEvents() {
        User testUser = new User(1, "username", "email");
        Event event1 = new Event();
        testUser.addEvent(event1);
        List<Event> expectedEvents = List.of(event1);
        assertEquals(expectedEvents, testUser.getParticipatingEvents());   

    }

    /**
     * Testing that removing a non existent event returns false and
     * does not affect the list
     */
    @Test
    public void testRemoveNonExistantEvent() {
        User testUser = new User(1, "username", "email");
        Event event1 = new Event();
        assertFalse(testUser.removeEvent(event1));
        assertEquals(new ArrayList<Event>(), testUser.getParticipatingEvents());
    }

    /**
     * Testing that removing an event works as intended
     */
    @Test
    public void testRemoveEvent() {
        User testUser = new User(1, "username", "email");
        Event event1 = new Event();
        testUser.addEvent(event1);
        assertTrue(testUser.removeEvent(event1));
        assertEquals(new ArrayList<Event>(), testUser.getParticipatingEvents());
    }

    /**
     * Testing that the equals method works with two classes
     */
    @Test
    public void testEquals() {
        User testUser = new User(1, "username", "email");
        User testUser1 = new User(1, "username", "email");
        assertEquals(testUser, testUser1);
    }

    /**
     * Testing that the equals method works when all variables have been changed
     */
    @Test
    public void testEqualsChangedAllParameters() {
        User testUser = new User(1, "username", "email");
        Event event1 = new Event();
        testUser.addEvent(event1);
        testUser.setDisplayLanguage("dutch");
        User testUser1 = new User(1, "username", "email");
        testUser1.addEvent(event1);
        testUser1.setDisplayLanguage("dutch");
        assertEquals(testUser, testUser1);
    }

    /**
     * Testing that the equals method works as intended when checking against null
     */
    @Test
    public void testEqualsNull() {
        User testUser = new User(1, "username", "email");
        assertNotEquals(null, testUser);
    }

    /**
     * Testing that if the languages are not equal, the users are not equal
     */
    @Test
    public void testNotEqualLanguage() {
        User testUser = new User(1, "username", "email");
        User testUser1 = new User(1, "username", "email");
        testUser.setDisplayLanguage("dutch");
        assertNotEquals(testUser, testUser1);
    }

    /**
     * Testing that if the events are not equal the users are not equal
     */
    @Test
    public void testNotEqualEvents() {
        User testUser = new User(1, "username", "email");
        Event event1 = new Event();
        testUser.addEvent(event1);
        User testUser1 = new User(1, "username", "email");
        assertNotEquals(testUser, testUser1);
    }

    /**
     * Testing that if all parameters are different then the users are not equal
     */
    @Test
    public void testNotEqualsAll() {
        User testUser = new User(1, "username", "email");
        User testUser1 = new User(1, "username", "email");
        Event event1 = new Event();
        testUser.setDisplayLanguage("dutch");
        testUser.addEvent(event1);
        assertNotEquals(testUser, testUser1);
    }

    // TODO fix this test
//    /**
//     * Checks that the getConfigLanguage method is able to read properties strings
//     */
//    @Test
//    public void testReadProperty() {
//        Properties properties = new Properties();
//        try {
//            properties.load(new StringReader("language=spanish"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        User testUser = new User(1, "username", "email");
//        assertEquals("spanish", testUser.getConfigLanguage(properties));
//    }

    // TODO fix this test
//    /**
//     * Checks that by default the english language is set if no property is available
//     */
//    @Test
//    public void testDefault() {
//        Properties properties = new Properties();
//        try {
//            properties.load(new StringReader(""));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        User testUser = new User(1, "username", "email");
//        assertEquals("english", testUser.getConfigLanguage(properties));
//    }
    
//    **
//        * Checks that it is able to write the configurations to an output stream
//     * @throws IOException - thrown if there is an IO problem
//     */
//    @Test
//    public void testSetProperty() throws IOException {
//        User testUser = new User(1, "username", "email");
//        Properties properties = new Properties();
//        testUser.writeServer("http://localhost:8080/");
//        FileInputStream inputStream = new FileInputStream("src/main/java/client/config/user_configs.properties");
//        properties.load(inputStream);
//        assertEquals("http://localhost:8080/", properties.getProperty("server"));
//    }/

    /**
     * Testing that if the hashcodes are equal of different users with same parameter values
     */
    @Test
    void testHashCode() {
        User testUser = new User(1, "username", "email");
        User testUser1 = new User(1, "username", "email");
        assertEquals(testUser.hashCode(), testUser1.hashCode());
    }

    /**
     * Testing that if the hashcodes are not equal of different users with different parameter values
     */
    @Test
    void testNotHashCode() {
        User testUser = new User(1, "username", "email");
        User testUser1 = new User(2, "username", "email");
//        testUser.setDisplayLanguage("dutch");
        assertNotEquals(testUser.hashCode(), testUser1.hashCode());
    }
}
