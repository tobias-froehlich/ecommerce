package com.neozo.ecommerce;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Something {
    public Otherthing otherthing;

    public Something(Otherthing otherthing) {
        System.out.println("Something is created.");
        this.otherthing = otherthing;
        this.otherthing.sayHello();
    }

}
