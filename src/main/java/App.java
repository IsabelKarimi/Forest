import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Animal> animals=Animal.getmInstance();
            model.put("animals",animals);
            return new ModelAndView(model, "sightingform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");

            Animal animals = new Animal(name,age,health);
            model.put("animals" ,animals);
            System.out.println(request.queryParams("name"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Animal> animals=Animal.getmInstance();
            model.put("animals",animals);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
