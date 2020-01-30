package application;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("chess")
@Data
public class ApplicationProperties {
    private String name;
}
