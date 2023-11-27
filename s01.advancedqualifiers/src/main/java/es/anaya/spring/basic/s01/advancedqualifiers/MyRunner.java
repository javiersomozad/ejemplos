package es.anaya.spring.basic.s01.advancedqualifiers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    @CustomerQualifier("normalCustomer")
    Customer p1;

    @Autowired
    @CustomerQualifier("importantCustomer")
    Customer p2;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(p1.profile() + " Dis: " + p1.discount());
        System.out.println(p2.profile() + " Dis: " + p2.discount());
    }
}