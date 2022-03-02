package lab5;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo buddy;
    BuddyInfo buddy2;

//    /**
//     * @throws java.lang.Exception
//     */
//    public static void setUpBeforeClass() throws Exception {
//        buddyInfo = new BuddyInfo();
//        bud2 = new BuddyInfo("bro1", "#totallyBroStreet 111", 69696969);
//    }

    protected void setUp() throws Exception {
        buddy = new BuddyInfo("Greg", "613-234-5321", "123 street");
        buddy2 = new BuddyInfo("Greg2", "613-234-5322", "124 street");
    }

    @Test
    public void getName() throws Exception {
        this.setUp();
        assertEquals("Greg", buddy.getName());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        this.setUp();
        assertEquals("613-234-5321", buddy.getPhoneNumber());
    }

    @Test
    public void getAddress() throws Exception {
        this.setUp();
        assertEquals("123 street", buddy.getAddress());
    }

    @Test
    public void setName() throws Exception {
        this.setUp();
        String newName = "NotGreg";
        buddy.setName(newName);
        assertEquals(newName, buddy.getName());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        this.setUp();
        String newPhoneNumber = "613-234-1234";
        buddy.setPhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, buddy.getPhoneNumber());
    }

    @Test
    public void setAddress() throws Exception {
        this.setUp();
        String newAddress = "123 new street";
        buddy.setAddress(newAddress);
        assertEquals(newAddress, buddy.getAddress());
    }
}