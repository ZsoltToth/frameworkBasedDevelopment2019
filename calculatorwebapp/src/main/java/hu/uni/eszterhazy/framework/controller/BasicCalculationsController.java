package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.api.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class BasicCalculationsController {

    Logger logger = LoggerFactory.getLogger(BasicCalculationsController.class);

    @Autowired
    private Calculator calculator;

    @RequestMapping("/add")
    public double add(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "b", defaultValue = "0.0") double b){
        logger.info(String.format("%s + %s",a,b));
        return calculator.add(a,b);
    }

    @RequestMapping("/sub")
    public double sub(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "b", defaultValue = "0.0") double b){
        logger.info(String.format("%s - %s",a,b));
        return calculator.sub(a,b);
    }

    @RequestMapping("/mul")
    public double mul(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "b", defaultValue = "0.0") double b){
        logger.info(String.format("%s * %s",a,b));
        return calculator.mul(a,b);
    }

    @RequestMapping("/div")
    public double div(@RequestParam(value = "a", defaultValue = "0.0") double a,
                      @RequestParam(value = "b", defaultValue = "0.0") double b){
        logger.info(String.format("%s / %s",a,b));
        return calculator.div(a,b);
    }

    @RequestMapping("/")
    public String index(){
        return "Calculator";
    }
}
