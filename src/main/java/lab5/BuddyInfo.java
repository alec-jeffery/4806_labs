package lab5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    private String name;
    private String phoneNumber;
    private String address;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public BuddyInfo() {
        this.name = "";
        this.phoneNumber = "";
    }

    public BuddyInfo(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "BuddyInfo[name=%s, phoneNumber='%s', address='%s']",
                this.name, this.phoneNumber, this.address
        );
    }
}
