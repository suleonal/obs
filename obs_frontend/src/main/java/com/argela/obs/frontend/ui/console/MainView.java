package com.argela.obs.frontend.ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.argela.obs.frontend.ui.constant.RoleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.com.argela.obs.client.api.GradeControllerApi;
import tr.com.argela.obs.client.api.LectureControllerApi;
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

    @Autowired
    GradeControllerApi gradeControllerApi;

    @Autowired
    LectureControllerApi lectureControllerApi;

    BufferedReader sysin;

    String token;

    List<String> menuStudent = new ArrayList();
    List<String> menuTeacher = new ArrayList();

    RoleType loggedRole;

    long hardCodedStudentId = 1;

    public MainView() {
        sysin = new BufferedReader(new InputStreamReader(System.in));
        menuStudent.add("Dersleri Getir");
        menuStudent.add("Yeni Ders Ekle");
        menuStudent.add("Ders Çıkar");
        menuStudent.add("Notları Göster");

        menuTeacher.add("Dersleri Göster");
        menuTeacher.add("Ders Hocası olarak ata");
        menuTeacher.add("Dersdeki öğrencileri göster");
        menuTeacher.add("Derse not girişi yap");
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
        int count = 1;
        for (String menuItem : menuStudent) {
            System.out.println((count++) + " -) " + menuItem);
        }
        System.out.print("Seciminiz:");
        int selection = Integer.parseInt(readLine());
        switch (selection) {
            case 1: {
                displayStudentLectures();
                break;
            }
            case 2: {
                addLectureToStudent();
                break;
            }
        }
        displayMainPageStudent();
    }

    private void displayStudentLectures() {
        displayBrake();
        System.out.println("Öğrenci ye ait dersler aşağıdaki gibidir: ");
        List<Lecture> lectures = studentControllerApi.getLecturesByStudentIdUsingGET(hardCodedStudentId, token);
        System.out.println("Ders\t\t\t| Hoca\t");
        displayBrakeShort();
        for (Lecture lecture : lectures) {
            System.out.println(lecture.getName() + "\t\t| " + lecture.getTeacher().getName());
        }
    }

    private void addLectureToStudent() {
        displayBrake();
        System.out.println("Eklenecek dersi seciniz");
        List<Lecture> allLectures = lectureControllerApi.getAllUsingGET1();
        List<Lecture> studentLectures = studentControllerApi.getLecturesByStudentIdUsingGET(hardCodedStudentId, token);

        Map<Long, Lecture> studentLecturesMapById = new HashMap<>();  //ogrencinin derslerini lecture id ile map le 
        for (Lecture lecture : studentLectures) {
            studentLecturesMapById.put(lecture.getId(), lecture);
        }

        Map<Integer, Lecture> lectureMapByIndex = new LinkedHashMap<>();
        int count = 1;
        for (Lecture lecture : allLectures) {
            if (studentLecturesMapById.get(lecture.getId()) != null)
                continue; // ders zaten ekli
            lectureMapByIndex.put(count, lecture);
            System.out.println(count + "-)" + lecture.getName());
            count++;
        }

        if(count ==1){
            System.out.println("Tüm dersleri eklendiniz. Yeni ders kalmadi");
            return;
        }

        int selection = Integer.parseInt(readLine());
        Lecture selectedLecture = lectureMapByIndex.get(selection);

        if (selectedLecture == null) {
            System.out.println("Ders secimi hatali");
            return;
        }

        studentControllerApi.addLectureToStudentUsingPUT(selectedLecture.getId(), hardCodedStudentId, token);
        System.out.println("Ders başarı ile eklendi.");

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
