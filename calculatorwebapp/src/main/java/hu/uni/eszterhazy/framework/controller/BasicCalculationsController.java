package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.api.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class BasicCalculationsController {

    @Autowired
    private Calculator calculator;

    @RequestMapping("/add")
    public double add(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "a", defaultValue = "0.0") double b){
        return calculator.add(a,b);
    }

    @RequestMapping("/sub")
    public double sub(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "a", defaultValue = "0.0") double b){
        return calculator.sub(a,b);
    }

    @RequestMapping("/mul")
    public double mul(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "a", defaultValue = "0.0") double b){
        return calculator.mul(a,b);
    }

    @RequestMapping("/div")
    public double div(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "a", defaultValue = "0.0") double b){
        return calculator.div(a,b);
    }

    @RequestMapping("/")
    public String index(){
        return "Calculator";
    }
}
