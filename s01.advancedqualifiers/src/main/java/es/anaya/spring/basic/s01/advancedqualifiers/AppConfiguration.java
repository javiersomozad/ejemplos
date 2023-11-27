package es.anaya.spring.basic.s01.advancedqualifiers;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @CustomerQualifier("normalCustomer")
    public Customer createStudent() {
        return new NormalCustomer();
    }

    @CustomerQualifier("importantCustomer")
    public Customer createManager() {
        return new ImportantCustomer();
    }
}