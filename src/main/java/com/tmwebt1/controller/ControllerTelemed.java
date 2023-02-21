package com.tmwebt1.controller;

import com.tmwebt1.repository.RecordRepository;
import com.tmwebt1.model.RecordTelemed;
import com.tmwebt1.model.User;
import com.tmwebt1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ControllerTelemed {

    User currUser;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecordRepository recordRepository;

    // PATIENT METHODS

    @GetMapping("/records")
    public String showRecords(Long userId, Model model) {
        User currUser = userRepository.findById(userId).get();
        model.addAttribute("currUser", currUser);
        model.addAttribute(recordRepository.findByUser(currUser));

        return "patient_all_records.html";
    }

    @GetMapping("/addNewRecord")
    public String addNewRecord(Long userId, int systolic, int diastolic, int heartBR, String status) {
        User currUser = userRepository.findById(userId).get();
        RecordTelemed newRecordTelemed = new RecordTelemed(new Date(), systolic, diastolic, heartBR, status);
        newRecordTelemed.setUser(currUser);
        recordRepository.save(newRecordTelemed);

        return "redirect:/records?userId=" + userId;
    }

    @GetMapping("/redirectToUserForm")
    public String redirectToCreateRecord(Long userId, Model model) {
        User currUser = userRepository.findById(userId).get();
        model.addAttribute("currUser", currUser);
        return "patient_home_page.html";
    }

    @GetMapping("/delete")
    public String delete(Long id) {

        RecordTelemed recordTelemed = recordRepository.findById(id).get();
        recordRepository.delete(recordTelemed);


        return "redirect:/records?userId=" + recordTelemed.getUser().getId();

    }


    // DOCTOR METHODS

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute(userRepository.findByType(0));

        return "doctor_home_page.html";
    }

    @GetMapping("/showRecordsForUser")
    public String showRecordsForUser(long userId, Model model) {
        User user = userRepository.findById(userId).get();
        model.addAttribute(user);
        model.addAttribute(recordRepository.findByUser(user));

        return "doctor_view_all_patient_records.html";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(String fname, String lname, String phone, String email, String password, String mbo) {
        User newUser = new User(fname, lname, phone, email, password, mbo);
        userRepository.save(newUser);

        return "redirect:/users";
    }

    @GetMapping("/redirectToForm")
    public String redirectToCreateUser() {

        return "doctor_create_new_patient.html";
    }

    @GetMapping("/deleteRecordByDoctor")
    public String deleteRecordByDoctor(Long id) {
        RecordTelemed recordTelemed = recordRepository.findById(id).get();
        recordRepository.delete(recordTelemed);

        return "redirect:/showRecordsForUser?userId=" + recordTelemed.getUser().getId();
    }

    @GetMapping("/deletePatientByDoctor")
    public String deletePatientByDoctor(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);

        return "redirect:/users";
    }


    // UTITILTY METHODS

    @GetMapping("/")
    public String redirectToLogin() {

        return "redirect:/login";
    }


    // LOGIN METHODS

    @GetMapping("/login")
    public String login() {

        return "login.html";
    }

    @GetMapping("/loginProcess")
    public String login(String email, String password, Model model) {

        User user = userRepository.findByEmailAndPassword(email, password);

        if (user != null) {
            System.out.println("User found: " + user);
            currUser = user;
            if (user.getType() == 0)
                return "redirect:/records?userId=" + user.getId();
            else
                return "redirect:/users";
        } else {
            model.addAttribute("userMessage", " Korisnik nije pronađen!");
            return "login.html";
        }
    }
}


