package se.lexicon.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("se.lexicon.*")
@PropertySource("classpath:application.properties")
public class AnnotationAppConfig {
}
