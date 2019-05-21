package com.example.demo.controller;


import com.example.demo.RunPython;
import com.example.demo.pojo.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {


    // http://localhost:2000/data?id=1-2-1&&name=22/22/2222
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public List<Product> getData(@RequestParam("id") String id,@RequestParam("name") String name) {

        Product p1 = new Product("1", "p1", 2.00);

        Product p2 = new Product("2", "p2", 2.00);

        List<Product> result = new ArrayList<>();
        result.add(p1);
        result.add(p2);
        result.add (new Product(id, name, 2.00));
        return result;
    }


    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public List<Product> postData(@RequestBody Product input) {

        Product p1 = new Product("3", "p1", 2.00);

        Product p2 = new Product("4", "p2", 2.00);

        List<Product> result = new ArrayList<>();
        result.add(p1);
        result.add(p2);
        result.add(input);
        return result;
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String getReview(@RequestParam("input") String input) {

        RunPython obj= new RunPython();
        String review = obj.execute(input);
        return review;
    }



}
