package sample.module.access;

import java.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(AccessModuleConfiguration.class)
@Configuration
public @interface EnableAccessModule {}
