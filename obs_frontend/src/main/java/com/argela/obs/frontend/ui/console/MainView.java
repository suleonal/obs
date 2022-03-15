package com.argela.obs.frontend.ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
import tr.com.argela.obs.client.model.Grade;
import tr.com.argela.obs.client.model.Lecture;
import tr.com.argela.obs.client.model.LoggedUser;
import tr.com.argela.obs.client.model.Student;
import tr.com.argela.obs.client.model.Teacher;

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
    LoggedUser loggedUser;

    public MainView() {
        sysin = new BufferedReader(new InputStreamReader(System.in));
        menuStudent.add("Dersleri Getir");
        menuStudent.add("Yeni Ders Ekle");
        menuStudent.add("Ders Çıkar");
        menuStudent.add("Notları Göster");
        menuStudent.add("Çıkış Yap");

        menuTeacher.add("Dersleri Göster");
        menuTeacher.add("Ders Hocası olarak ata");
        menuTeacher.add("Dersteki öğrencileri göster");
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
        System.out.println("Giriş için bilgileri doldurunuz");
        System.out.print("Kullanici adi:");
        String username = readLine();
        System.out.print("Şifre :");
        String password = readLine();
        if (login(username, password)) {

            findLoginType();
            displayMainPage();
        } else {
            displayBrake();
            System.out.println("Giriş bilgileri doğru değil lütfen tekrar deneyiniz");
            displayLoginPage();
        }
    }

    private void findLoginType() {
        loggedUser = userControllerApi.getLoggedUserUsingGET(token);
        loggedRole = RoleType.Student.getValue() == loggedUser.getRoleType() ? RoleType.Student : RoleType.Teacher;

        System.out.println("Hoşgeldin " + loggedUser.getEntityName());
    }

    private void displayMainPage() {
        switch (loggedRole) {
            case Student: {
                displayMainPageStudent();
                break;
            }
            case Teacher: {
                displayMainPageTeacher();
                break;
            }
        }

    }

    private void displayMainPageTeacher() {
        displayBrake();
        System.out.println("Öğretmen Ana sayfasına hoşgeldiniz");
        int count = 1;
        for (String menuItem : menuTeacher) {
            System.out.println((count++) + " -) " + menuItem);
        }
        System.out.print("Seciminiz:");
        int selection = Integer.parseInt(readLine());
        switch (selection) {
            case 1: {
                displayTeacherLectures();
                break;
            }
            case 2: {
                assignTeacherToLecture();
                break;
            }
            case 3: {
                getStudentByLectureId();
                break;
            }
            case 4: {
                value();
                break;
            }
            case 5: {
                logout();
                displayLoginPage();
                break;
            }
        }
        displayMainPageTeacher();
    }

    private void displayTeacherLectures() {
        displayBrake();
        System.out.println("Öğretmene ait dersler aşağıdaki gibidir: ");
        List<Lecture> lectures = teacherControllerApi
                .getLecturesByTeacherIdUsingGET(loggedUser.getEntityId().intValue(), token);
        System.out.println("Ders\t\t\t| Hoca\t");
        displayBrakeShort();
        for (Lecture lecture : lectures) {
            System.out.println(lecture.getName() + "\t\t| " + lecture.getTeacher().getName());
        }
    }

    private void assignTeacherToLecture() {

        displayBrake();
        System.out.println("Dersi seçiniz: ");

        List<Lecture> teacherLectures = teacherControllerApi
                .getLecturesByTeacherIdUsingGET(loggedUser.getEntityId().intValue(), token);

        List<Lecture> allLectures = lectureControllerApi.getAllUsingGET1(token);

        Map<Integer, Lecture> teacherLecturesMapByIndex = new HashMap<>();
        for (Lecture lecture : teacherLectures) {
            teacherLecturesMapByIndex.put(lecture.getId().intValue(), lecture);
        }

        Map<Integer, Lecture> lectureMapByIndex = new LinkedHashMap<>();
        int count_ = 1;
        for (Lecture lecture : allLectures) {
            if (teacherLecturesMapByIndex.get(lecture.getId().intValue()) != null)
                continue; // ders zaten ekli
            lectureMapByIndex.put(count_, lecture);
            System.out.println(count_ + "-)" + lecture.getName());
            count_++;
        }
        if (count_ == 1) {
            System.out.println("Tüm dersleri eklediniz.");
            return;
        }

        int selection = Integer.parseInt(readLine());
        Lecture selectedLecture = lectureMapByIndex.get(selection);

        if (selectedLecture == null) {
            System.out.println("Ders secimi hatali");
            return;
        }

        // ders ve öğretmeni seçti. selected
        lectureControllerApi.assignTeacherToLectureUsingPUT(selectedLecture.getId(), loggedUser.getEntityId(), token);

    }

    private void value() {
        displayBrake();
        System.out.println("Dersi seçiniz: ");

        List<Lecture> lectures = teacherControllerApi
                .getLecturesByTeacherIdUsingGET(loggedUser.getEntityId().intValue(), token);

        Map<Integer, Lecture> lectureMapByIndex = new LinkedHashMap<>();
        int count = 1;
        for (Lecture lecture : lectures) {
            lectureMapByIndex.put(count, lecture);
            System.out.println(count + "-)" + lecture.getName());
            count++;
        }
        int selection = Integer.parseInt(readLine());
        Lecture selectedLecture = lectureMapByIndex.get(selection);

        if (selectedLecture == null) {
            System.out.println("Ders secimi hatali");
            return;
        }
        // dersi seçti. selectedLecture
        List<Student> students = studentControllerApi.getStudentByLectureIdUsingGET(selectedLecture.getId().intValue(),
                token);
        System.out.println("Öğrenci\t");
        displayBrakeShort();
        for (Student student : students) {
            System.out.print(student.getName() + ":");
            int value = Integer.parseInt(readLine());
            gradeControllerApi.valueUsingPUT(selectedLecture.getId(), student.getId(), token, value);
        }

    }

    private void getStudentByLectureId() {
        displayBrake();
        System.out.println("Dersi seçiniz: ");

        List<Lecture> lectures = teacherControllerApi
                .getLecturesByTeacherIdUsingGET(loggedUser.getEntityId().intValue(), token);

        Map<Integer, Lecture> lectureMapByIndex = new LinkedHashMap<>();
        int count = 1;
        for (Lecture lecture : lectures) {
            lectureMapByIndex.put(count, lecture);
            System.out.println(count + "-)" + lecture.getName());
            count++;
        }
        int selection = Integer.parseInt(readLine());
        Lecture selectedLecture = lectureMapByIndex.get(selection);

        if (selectedLecture == null) {
            System.out.println("Ders secimi hatali");
            return;
        }
        // dersi seçti. selectedLecture
        List<Student> students = studentControllerApi.getStudentByLectureIdUsingGET(selectedLecture.getId().intValue(),
                token);
        System.out.println(" Öğrenci\t");
        displayBrakeShort();
        for (Student student : students) {
            System.out.println(student.getName());
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
            case 3: {
                deleteLectureToStudent();
                break;
            }
            case 4: {
                getGradeStudentById();
                break;
            }
            case 5: {
                logout();

                System.exit(0);
                break;
            }
        }
        displayMainPageStudent();
    }

    private void displayStudentLectures() {
        displayBrake();
        System.out.println("Öğrenciye ait dersler aşağıdaki gibidir: ");
        List<Lecture> lectures = studentControllerApi.getLecturesByStudentIdUsingGET(loggedUser.getEntityId(), token);
        System.out.println("Ders\t\t\t| Hoca\t");
        displayBrakeShort();
        for (Lecture lecture : lectures) {
            System.out.println(lecture.getName() + "\t\t| " + lecture.getTeacher().getName());
        }
    }

    private void deleteLectureToStudent() {
        displayBrake();
        System.out.println("Çıkaracağınız dersi seçin: ");

        List<Lecture> studentLectures = studentControllerApi.getLecturesByStudentIdUsingGET(loggedUser.getEntityId(),
                token);

        Map<Integer, Lecture> lectureMapByIndex = new LinkedHashMap<>();
        int count = 1;
        for (Lecture lecture : studentLectures) {
            lectureMapByIndex.put(count, lecture);
            System.out.println(count + "-)" + lecture.getName());
            count++;
        }
        int selection = Integer.parseInt(readLine());
        Lecture selectedLecture = lectureMapByIndex.get(selection);

        if (selectedLecture == null) {
            System.out.println("Ders secimi hatali");
            return;
        }

        studentControllerApi.deleteLectureToStudentUsingDELETE(selectedLecture.getId(), loggedUser.getEntityId(),
                token);
        System.out.println("Ders başarı ile silindi.");
    }

    private void addLectureToStudent() {
        displayBrake();
        System.out.println("Eklenecek dersi seciniz");
        List<Lecture> allLectures = lectureControllerApi.getAllUsingGET1(token);
        List<Lecture> studentLectures = studentControllerApi.getLecturesByStudentIdUsingGET(loggedUser.getEntityId(),
                token);

        Map<Long, Lecture> studentLecturesMapById = new HashMap<>(); // ogrencinin derslerini lecture id ile map le
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

        if (count == 1) {
            System.out.println("Tüm dersleri eklediniz. Yeni ders kalmadi");
            return;
        }

        int selection = Integer.parseInt(readLine());
        Lecture selectedLecture = lectureMapByIndex.get(selection);

        if (selectedLecture == null) {
            System.out.println("Ders secimi hatali");
            return;
        }

        studentControllerApi.addLectureToStudentUsingPUT(selectedLecture.getId(), loggedUser.getEntityId(), token);
        System.out.println("Ders başarı ile eklendi.");

    }

    private void getGradeStudentById() {
        displayBrake();
        List<Grade> grades = gradeControllerApi.getGradeStudentByIdUsingGET(loggedUser.getEntityId(), token);
        System.out.println("Ders\t\t\t| Not\t");
        displayBrakeShort();
        for (Grade grade : grades) {
            System.out.println(grade.getLecture().getName() + "\t\t| " + grade.getValue());
        }
    }

    private void logout() {
        userControllerApi.logoutUsingDELETE(token);
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
