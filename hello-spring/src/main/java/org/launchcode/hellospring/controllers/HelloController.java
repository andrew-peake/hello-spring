package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//
//    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<select name = 'language'>" +
                "<option value = 'English' selected> English </option>" +
                "<option value = 'French'> French </option>" +
                "<option value = 'Spanish'> Spanish </option>" +
                "<option value = 'Italian'> Italian </option>" +
                "<option value = 'German'> German </option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String greeting = "";

        if (language.equals("English")) {
            greeting = "Hello";
        } else if (language.equals("French")) {
            greeting = "Bonjour";
        }else if (language.equals("Spanish")) {
            greeting = "Hola";
        }else if (language.equals("Italian")) {
            greeting = "Ciao";
        }else if (language.equals("German")) {
            greeting = "Guten Tag";
        }

        return greeting + " " + name;
    }


}