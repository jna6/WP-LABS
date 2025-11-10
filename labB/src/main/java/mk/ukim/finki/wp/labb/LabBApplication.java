package mk.ukim.finki.wp.labb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LabBApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabBApplication.class, args);
    }

}
