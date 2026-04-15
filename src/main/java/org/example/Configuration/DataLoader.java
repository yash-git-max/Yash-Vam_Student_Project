package org.example.Configuration;


import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

   @Bean
    public CommandLineRunner loadInitialStudent(StudentRepository studentRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                studentRepository.save(new Student(1, "Vamshi"));
                studentRepository.save(new Student(2, "Rahul"));
                studentRepository.save(new Student(3, "Kiran"));

            }
        };


    }

}
