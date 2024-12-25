package com.malaquias.restwithspringbootandjava;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private  final AtomicLong counter  = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Exception();
        }
        return converteToDouble(numberOne) + converteToDouble(numberTwo);
    }

    private Double converteToDouble(String strNumber) {
        return 1D;
    }

    private boolean isNumeric(String numberOne) {
        return true;
    }
}
