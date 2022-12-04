package by.domain.configuration;

import by.domain.annotation.Vehicle;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "by.domain.beansAnnotated",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Vehicle.class)
)
public class ComponentScanIncludeFilterConfig {
}
