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


package tr.com.argela.obs.client.api;

import tr.com.argela.obs.client.model.Lecture;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for LectureControllerApi
 */
@Ignore
public class LectureControllerApiTest {

    private final LectureControllerApi api = new LectureControllerApi();

    
    /**
     * assignTeacherToLecture
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void assignTeacherToLectureUsingPUTTest() {
        Long lectureId = null;
        Long teacherId = null;
        api.assignTeacherToLectureUsingPUT(lectureId, teacherId);

        // TODO: test validations
    }
    
    /**
     * deleteById
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteByIdUsingDELETE1Test() {
        Long id = null;
        api.deleteByIdUsingDELETE1(id);

        // TODO: test validations
    }
    
    /**
     * findById
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findByIdUsingGET1Test() {
        Long id = null;
        Lecture response = api.findByIdUsingGET1(id);

        // TODO: test validations
    }
    
    /**
     * getAll
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAllUsingGET1Test() {
        List<Lecture> response = api.getAllUsingGET1();

        // TODO: test validations
    }
    
    /**
     * save
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void saveUsingPOST1Test() {
        Lecture lecture = null;
        Lecture response = api.saveUsingPOST1(lecture);

        // TODO: test validations
    }
    
}