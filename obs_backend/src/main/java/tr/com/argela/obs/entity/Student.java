package tr.com.argela.obs.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private int tel;

    @Column(name = "adress")
    private String adress;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Grade> grades;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_lecture", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "lecture_id", referencedColumnName = "ID") })
    @JsonIgnore
    private List<Lecture> lectures = new ArrayList<Lecture>();

}
