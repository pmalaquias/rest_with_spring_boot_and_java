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
        if(strNumber == null) return 0D;

        String number = strNumber.replaceAll(",", ".");

        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String numberOne) {
        if(numberOne == null) return false;
        String number = numberOne.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
