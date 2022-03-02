package lab5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    AddressBook addressBook;
    List<BuddyInfo> buddyArray;
    BuddyInfo buddyList[];

    protected void setUp() throws Exception {
        addressBook = new AddressBook();
        buddyArray = new ArrayList<BuddyInfo>();

        BuddyInfo buddy1 = new BuddyInfo("Greg1", "613-234-5321", "121 street");
        BuddyInfo buddy2 = new BuddyInfo("Greg2", "613-234-5322", "122 street");
        BuddyInfo buddy3 = new BuddyInfo("Greg3", "613-234-5323", "123 street");
        BuddyInfo buddy4 = new BuddyInfo("Greg4", "613-234-5324", "124 street");
        buddyList = new BuddyInfo[]{buddy1, buddy2, buddy3, buddy4};
        for (int i=0; i<4; i++) {
            buddyArray.add(buddyList[i]);
        }
    }
    @Test
    public void addBuddyInfo() throws Exception {
        this.setUp();
        addressBook.addBuddyInfo(buddyList[0]);
        List<BuddyInfo> getBuddy = addressBook.getBuddyInfoList();
        BuddyInfo buddyThatWasGot = getBuddy.get(0);

        assertEquals("Greg1", buddyThatWasGot.getName());
        assertEquals("613-234-5321", buddyThatWasGot.getPhoneNumber());
    }
}