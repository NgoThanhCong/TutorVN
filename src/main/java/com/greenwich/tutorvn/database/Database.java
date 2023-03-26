package com.greenwich.tutorvn.database;

import com.greenwich.tutorvn.model.SubjectClass;
import com.greenwich.tutorvn.repository.CustomerRepository;
import com.greenwich.tutorvn.repository.SubjectRepository;
import com.greenwich.tutorvn.repository.TutorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Database {

    @Bean
    CommandLineRunner initDatabase(TutorRepository tutorRepository , CustomerRepository customerRepository, SubjectRepository subjectRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                SubjectClass subjectClass1 = new SubjectClass();
                subjectClass1.setGrade(1);
                subjectClass1.setName("Mon Toan lop 1");
                subjectClass1.setCategory("toan ");

                SubjectClass subjectClass4 = new SubjectClass();
                subjectClass4.setGrade(4);
                subjectClass4.setName("Mon Toan Lop 4");
                subjectClass4.setCategory("toan ");

                SubjectClass subjectClass2 = new SubjectClass();
                subjectClass2.setGrade(2);
                subjectClass2.setName("Mon Toan Lop 2");
                subjectClass2.setCategory("toan ");

                SubjectClass subjectClass3 = new SubjectClass();
                subjectClass3.setGrade(3);
                subjectClass3.setName("Mon Toan Lop 3");
                subjectClass3.setCategory("toan ");

                subjectRepository.save(subjectClass1);
                subjectRepository.save(subjectClass2);
                subjectRepository.save(subjectClass3);
                subjectRepository.save(subjectClass4);

                SubjectClass subjectClass1v = new SubjectClass();
                subjectClass1v.setGrade(1);
                subjectClass1v.setName("Mon van lop 1");
                subjectClass1v.setCategory("van ");

                SubjectClass subjectClass4v = new SubjectClass();
                subjectClass4v.setGrade(4);
                subjectClass4v.setName("Mon van Lop 4");
                subjectClass4v.setCategory("van ");

                SubjectClass subjectClass2v = new SubjectClass();
                subjectClass2v.setGrade(2);
                subjectClass2v.setName("Mon van Lop 2");
                subjectClass2v.setCategory("van ");

                SubjectClass subjectClass3v = new SubjectClass();
                subjectClass3v.setGrade(3);
                subjectClass3v.setName("Mon van Lop 3");
                subjectClass3v.setCategory("van ");

                subjectRepository.save(subjectClass1v);
                subjectRepository.save(subjectClass2v);
                subjectRepository.save(subjectClass3v);
                subjectRepository.save(subjectClass4v);

            }
        };
    }
}