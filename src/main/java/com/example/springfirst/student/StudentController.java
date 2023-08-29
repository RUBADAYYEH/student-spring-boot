package com.example.springfirst.student;

import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {


    private final StudentServie ss;
@Autowired
    public StudentController(StudentServie ss) {
        this.ss = ss;
    }
     @GetMapping
    public List<Student> info(){
        return ss.info();
    }
    @PostMapping
    public String registerNewStudent(@RequestBody Student student){
      return  ss.addNewStudent(student);
    }
    @ExceptionHandler(value
            = EmailTakenException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object>
    handleCustomerAlreadyExistsException(
            EmailTakenException ex)
    {
        return new ResponseEntity<>("Email Taken :(", HttpStatus.CONFLICT);
    }

    @DeleteMapping(path="{id}")
    public String deleteStudent(@PathVariable ("id") Long id ){
       return ss.deleteStudent(id);
    }
    @ExceptionHandler(value
            = NotExistingIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object>
    handleNotFoundIdException(
            NotExistingIdException ex)
    {
        return new ResponseEntity<>("USER ID NOT FOUND :(", HttpStatus.NOT_FOUND);
    }
  @PutMapping(path = "{id}")
    public String  updateStudent(@PathVariable("id")Long id , @RequestParam (required=false) String name , @RequestParam(required = false) String email){
       return ss.updateStudent(id,name,email);

  }



    ///info ?
    //service layer
}
