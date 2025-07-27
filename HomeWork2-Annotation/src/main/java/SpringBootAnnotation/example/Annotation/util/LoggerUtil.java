package SpringBootAnnotation.example.Annotation.util;


import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {
    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}
