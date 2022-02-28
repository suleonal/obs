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
import javax.persistence.Table;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonIgnore
    private List<Grade> grades;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_lecture", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "lecture_id", referencedColumnName = "ID") })
    @JsonIgnore
    private List<Lecture> lectures = new ArrayList<Lecture>();

}
