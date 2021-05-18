package com.neozo.ecommerce.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {


    public Controller() {

        System.out.println("Controller created.");
    }

    @RequestMapping("/")
    public String index() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setClassForTemplateLoading(Controller.class, "/templates/");
        try {
            Template template = cfg.getTemplate("index.ftl");
            Map<String, Object> input = new HashMap<>();
            input.put("name", "Foo");
            Writer writer = new StringWriter();
            template.process(input, writer);
            System.out.println(writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Could not insert data to template.";
    }

}
