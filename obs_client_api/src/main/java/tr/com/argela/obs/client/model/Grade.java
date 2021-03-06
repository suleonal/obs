/*
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package tr.com.argela.obs.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tr.com.argela.obs.client.model.Lecture;
import tr.com.argela.obs.client.model.Student;

/**
 * Grade
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-03-14T16:52:04.716+03:00")
public class Grade {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("lecture")
  private Lecture lecture = null;

  @JsonProperty("student")
  private Student student = null;

  @JsonProperty("value")
  private Integer value = null;

  public Grade id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Grade lecture(Lecture lecture) {
    this.lecture = lecture;
    return this;
  }

   /**
   * Get lecture
   * @return lecture
  **/
  @ApiModelProperty(value = "")
  public Lecture getLecture() {
    return lecture;
  }

  public void setLecture(Lecture lecture) {
    this.lecture = lecture;
  }

  public Grade student(Student student) {
    this.student = student;
    return this;
  }

   /**
   * Get student
   * @return student
  **/
  @ApiModelProperty(value = "")
  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Grade value(Integer value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Grade grade = (Grade) o;
    return Objects.equals(this.id, grade.id) &&
        Objects.equals(this.lecture, grade.lecture) &&
        Objects.equals(this.student, grade.student) &&
        Objects.equals(this.value, grade.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lecture, student, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Grade {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lecture: ").append(toIndentedString(lecture)).append("\n");
    sb.append("    student: ").append(toIndentedString(student)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

