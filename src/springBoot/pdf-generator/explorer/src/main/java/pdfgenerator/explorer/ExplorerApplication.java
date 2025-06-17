package pdfgenerator.explorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"pdfgenerator","pdfgenerator.core"}
)
public class ExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExplorerApplication.class, args);
    }

}
