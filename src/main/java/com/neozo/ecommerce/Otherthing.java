package com.neozo.ecommerce;

import org.springframework.context.annotation.Configuration;

import javax.print.attribute.standard.MediaSize;

@Configuration
public class Otherthing {

    public Otherthing() {
        System.out.println("Otherthing is created");
    }

    public void sayHello() {
        System.out.println("Otherthing says hello.");
    }
}
