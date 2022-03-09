package com.argela.obs.frontend.ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.argela.obs.frontend.ui.constant.RoleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.com.argela.obs.client.api.StudentControllerApi;
import tr.com.argela.obs.client.api.TeacherControllerApi;
import tr.com.argela.obs.client.api.UserControllerApi;
import tr.com.argela.obs.client.model.Lecture;

@Component
public class MainView {

    @Autowired
    UserControllerApi userControllerApi;

    @Autowired
    StudentControllerApi studentControllerApi;

    @Autowired
    TeacherControllerApi teacherControllerApi;

    BufferedReader sysin;

    String token;

    List<String> menuStudent = new ArrayList();

    RoleType loggedRole;

    public MainView() {
        sysin = new BufferedReader(new InputStreamReader(System.in));
        menuStudent.add("Dersleri Getir");
        menuStudent.add("Yeni Ders Ekle");
        menuStudent.add("Ders Çıkar");
        menuStudent.add("Notları Göster");
    }

    public void start() {
        displayWelcomePage();
        displayLoginPage();
    }

    public String readLine() {
        try {
            return sysin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "NULL";
        }
    }

    private void displayLoginPage() {
        System.out.println("Giriş için bilgilerini doldurunuz");
        System.out.print("Kullanici adi:");
        String username = readLine();
        System.out.print("Şifre :");
        String password = readLine();
        if (login(username, password)) {
            findLoginType();

            displayMainPage();
        } else {
            displayBrake();
            System.out.println("Giriş bilgilerini doğru değil lütfen tekrar deneyiniz");
            displayLoginPage();
        }
    }

    private void findLoginType() {
        try {
            teacherControllerApi.getAllUsingGET3(token);
            loggedRole = RoleType.Teacher;
        } catch (Exception e) {
            loggedRole = RoleType.Student;
        }
    }

    private void displayMainPage() {
        switch (loggedRole) {
            case Student: {
                displayMainPageStudent();
                break;
            }
            case Teacher: {
                break;
            }
        }

    }

    private void displayMainPageStudent() {
        displayBrake();
        System.out.println("Öğrenci Ana sayfasına hoşgeldiniz");
        int count =1;
        for (String menuItem : menuStudent) {
            System.out.println((count++)+" -) "+menuItem);
        }
        System.out.print("Seciminiz:");
        int selection = Integer.parseInt(readLine());
        switch(selection){
            case 1:{
                displayStudentLectures();
                break;
            }
        }
        displayMainPageStudent();
    }

    private void displayStudentLectures() {
        displayBrake();
        System.out.println("Öğrenci ye ait dersler aşağıdaki gibidir: ");
        List<Lecture> lectures = studentControllerApi.getLecturesByStudentIdUsingGET(1l, token);
        System.out.println("Ders\t\t\t| Hoca\t");
        displayBrakeShort();
        for(Lecture lecture : lectures){
            System.out.println(lecture.getName()+"\t\t| "+lecture.getTeacher().getName());    
        }
    }

    private boolean login(String username, String password) {
        try {
            this.token = userControllerApi.loginUsingPUT(password, username);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void displayBrake() {
        System.out.println("-----------------------------------------------------------------------------");
    }

    private void displayBrakeShort() {
        System.out.println("------------------------------------------------");
    }

    private void displayWelcomePage() {
        System.out.println("Ogrenci Bilgi Sistemi");
        System.out.println("Version 1.8");
        displayBrake();
    }
}
