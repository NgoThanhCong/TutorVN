package com.greenwich.tutorvn.controller;
import com.greenwich.tutorvn.model.ResponseObject;
import com.greenwich.tutorvn.model.SubjectClass;
import com.greenwich.tutorvn.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController  // khai bao anotation restcontroller de tao ra 1 class Rest API
@RequestMapping(path  = "/api/v1/subject")  //tao ra URL cos dang /api/

public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/getsubject")  // gui yeu cau de lay du lieu
    ResponseEntity<ResponseObject> getListSubject()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok","Success",
                subjectRepository.findAll()));
    }

    @PostMapping("/insertsubject")
    ResponseEntity<ResponseObject> insert(@RequestBody SubjectClass subject)
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok","Success",
                subjectRepository.save(subject)));
    }

    @DeleteMapping("/{id}")
    void delete (@PathVariable Long id)
    {
        subjectRepository.deleteById(id);
    }

    @GetMapping("/{name}")
    ResponseEntity<ResponseObject> findByName(@PathVariable String name)
    {
        Optional<SubjectClass> optionalSubject = subjectRepository.findByName(name);
        if(optionalSubject.isPresent())
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok","Success",
                    optionalSubject.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("NOT_Found","subject not found",
               ""));
    }
}
