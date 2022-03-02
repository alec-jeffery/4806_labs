package lab5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class AddressBook {

    @OneToMany
    private List<BuddyInfo> buddyInfoList;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    public AddressBook() {
        this.buddyInfoList = new ArrayList<BuddyInfo>();
//        this.id = (long) Math.random();
    }

    public AddressBook(int id) {
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    public AddressBook(List<BuddyInfo> buddyInfoList) {
        this.buddyInfoList = buddyInfoList;
    }

    public void addBuddyInfo(BuddyInfo buddy) {
        this.buddyInfoList.add(buddy);
    }

    public void addBuddyInfoList(List<BuddyInfo> buddyList) {
        this.buddyInfoList.addAll(buddyList);
    }

    public List<BuddyInfo> getBuddyInfoList() {
        return buddyInfoList;
    }

    public void removeBuddyInfo(BuddyInfo buddy) throws Exception{
        boolean buddyFound = false;
        if (buddyInfoList.contains(buddy)) {
            this.buddyInfoList.remove(buddy);
            buddyFound = true;
        }
        else {
            BuddyInfo buddyInList;

            for (int i = 0; i < this.buddyInfoList.size(); ) {
                buddyInList = this.buddyInfoList.get(i);
                if (buddyInList.getName() == buddy.getName() && buddyInList.getPhoneNumber() == buddy.getPhoneNumber()) {
                    this.buddyInfoList.remove(i);
                    buddyFound = true;
                    break;
                }
            }
        }
        if (!buddyFound) throw new Exception("no such BuddyInfo found");

    }

    public void printBuddies() {
        for (int i = 0; i<buddyInfoList.size(); i++) {
            BuddyInfo buddy = buddyInfoList.get(i);
            System.out.println("buddy number" + i + "'s name is "+ buddy.getName() + "and their phone number is " + buddy.getPhoneNumber());
        }
    }

//    public static void main(String[] args) {
//        BuddyInfo buddyGenerator = new BuddyInfo();
//        List<BuddyInfo> buddyList = new ArrayList<BuddyInfo>();
//        for (int i=0; i < 5; i++) {
//            buddyGenerator.setName("Greg" + i);
//            buddyGenerator.setPhoneNumber("613-325-432" + i);
//            buddyList.add(buddyGenerator);
//        }
//        AddressBookModel addressBook = new AddressBookModel(buddyList);
//        addressBook.printBuddies();
//    }
}


