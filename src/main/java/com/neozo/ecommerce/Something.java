package com.neozo.ecommerce;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Something {
    public Otherthing otherthing;

    public Something(Otherthing otherthing) {
        this.otherthing = otherthing;
        System.out.println("Something is created.");
    }

}
