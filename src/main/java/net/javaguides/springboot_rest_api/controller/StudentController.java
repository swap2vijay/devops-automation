package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Vijayakumar", "Thangavel");
        return  ResponseEntity.ok()
                .header("custom-header", "Vijay")
                .body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Vijay", "Kumar"));
        studentList.add(new Student(2, "Ramesh", "Kumar"));
        studentList.add(new Student(3, "Raja", "Vijay"));
        studentList.add(new Student(4, "Vijay", "Thangavel"));
        studentList.add(new Student(5, "Suresh", "Kumar"));
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName
    )
    {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName
    ) {
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    //Spring Boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring Boot REST API that handles HTTP DELETE Request - delete existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);

        return ResponseEntity.ok("Deleted Student Sucessfully "+studentId);
    }

}
