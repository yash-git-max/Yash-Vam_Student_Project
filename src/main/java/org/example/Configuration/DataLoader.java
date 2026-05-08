package org.example.Configuration;


import org.example.domain.Login;
import org.example.domain.Student;
import org.example.repository.LoginRepository;
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
                studentRepository.save(new Student(4, "stephen"));
                studentRepository.save(new Student(5, "saketh"));
                studentRepository.save(new Student(6, "vivek"));
                studentRepository.save(new Student(7, "teja"));
                studentRepository.save(new Student(8, "khaja"));


            }
        };


    }

    @Bean
    public CommandLineRunner loadInitialLogin(LoginRepository loginRepository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                loginRepository.save(new Login(1,"vamshig9012@gmail.com","vamshi"));
                loginRepository.save(new Login(2,"basha@gmail.com","1234"));
                loginRepository.save(new Login(3,"kiran@gmail.com","1234"));
                loginRepository.save(new Login(4,"stephen@gmail.com","1234"));
                loginRepository.save(new Login(5,"Vivek@gmail.com","1234"));

            }
        };
    }

}
