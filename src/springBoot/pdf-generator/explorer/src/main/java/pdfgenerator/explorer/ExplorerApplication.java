package pdfgenerator.explorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Explorer application.
 */
@SpringBootApplication(
        scanBasePackages = {"pdfgenerator","pdfgenerator.core","pdfgenerator.core.registry"}
)
public class ExplorerApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ExplorerApplication.class, args);
    }

}
