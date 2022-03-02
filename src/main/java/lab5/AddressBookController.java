package lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/viewBuddies")
    public String viewBuddies(@RequestParam Long addressId, Model model) {
        String buddyList = "";
        AddressBook addressBook;
        addressBook = addressBookRepository.findById(addressId).get();
        for (BuddyInfo buddyInfo : addressBook.getBuddyInfoList()) {
            buddyList += buddyInfo.toString() + "\n";
        }

        model.addAttribute("addressId", addressId);
        model.addAttribute("buddyList", buddyList);
        return "viewBuddies";
    }

    @GetMapping("/addBuddyInfoToAddressBook")
    public String addBuddyInfoToAddressBook(Model model, @RequestParam(value = "addressId", defaultValue = "-1") Long addressId) {
        AddressBook addressBook = !addressBookRepository.existsById(addressId) ? new AddressBook() : addressBookRepository.findById(addressId).get();
        model.addAttribute("addressBook", addressBook);

        ArrayList<BuddyInfo> buddyInfoArrayList = new ArrayList<>();
        for (BuddyInfo buddy : buddyInfoRepository.findAll()) {
            buddyInfoRepository.save(buddy);
            buddyInfoArrayList.add(buddy);
        }
        model.addAttribute("buddyInfoList", buddyInfoArrayList);

        return "createAddressBook";
    }

    @GetMapping("/createBuddyInfo")
    public String createBuddyInfo(Model model) {
        model.addAttribute(new BuddyInfo());
        return "createBuddyInfo";
    }

    @PostMapping("/newAddressBook")
    @ResponseBody
//    @Transactional
    /**
     * To add a list of buddyInfo's:
     * https://www.baeldung.com/thymeleaf-list
     */
    public void newAddressBook(@ModelAttribute BuddyInfo buddyInfo) {
        System.out.println(buddyInfo);
        System.out.println(buddyInfo.getName());
        System.out.println(buddyInfo.getPhoneNumber());

        AddressBook addressBook = new AddressBook();

        addressBook.addBuddyInfo(buddyInfo);
//        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
    }

    @PostMapping("/newBuddyInfo")
    @ResponseBody
    public void newBuddyInfo(@ModelAttribute BuddyInfo buddyInfo) {
        buddyInfoRepository.save(buddyInfo);
    }

    @PostMapping("/addressBook/{addressId}/addBuddyInfo/{buddyId}")
    @ResponseBody
    public void buddyInfo(@PathVariable Long addressId, @PathVariable Long buddyId) {
        if (addressBookRepository.existsById(addressId)) {
            AddressBook addressBook;
            BuddyInfo buddyInfo;

            addressBook = addressBookRepository.findById(addressId).get();
            buddyInfo = buddyInfoRepository.findById(buddyId).get();
            addressBook.addBuddyInfo(buddyInfo);
            addressBookRepository.save(addressBook);
        }

    }


    @DeleteMapping("/addressBook/{addressId}/deleteBuddyInfo/{buddyId}")
    @ResponseBody
    public void addressBook(@PathVariable Long addressId, @PathVariable Long buddyId) {
        if (addressBookRepository.existsById(addressId)) {
            AddressBook addressBook;
            BuddyInfo buddyInfo;

            addressBook = addressBookRepository.findById(addressId).get();
            buddyInfo = buddyInfoRepository.findById(buddyId).get();
            try {
                addressBook.removeBuddyInfo(buddyInfo);
                System.out.println("buddy removed!");
                addressBookRepository.save(addressBook);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }


}
