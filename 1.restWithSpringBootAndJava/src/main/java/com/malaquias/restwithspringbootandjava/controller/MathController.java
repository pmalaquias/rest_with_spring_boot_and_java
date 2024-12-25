package com.malaquias.restwithspringbootandjava.controller;

import com.malaquias.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;
import com.malaquias.restwithspringbootandjava.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.malaquias.restwithspringbootandjava.converter.NumberConverter.converteToDouble;
import static com.malaquias.restwithspringbootandjava.converter.NumberConverter.isNumeric;


@RestController
public class MathController {
    private  final AtomicLong counter  = new AtomicLong();
    private final SimpleMath math = new SimpleMath();

    /*Sum*/
    // http://localhost:8080/sum/10/5
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(converteToDouble(numberOne), converteToDouble(numberTwo));
    }

    /*Subtraction*/
    // http://localhost:8080/subtraction/10/5
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.subtraction(converteToDouble(numberOne), converteToDouble(numberTwo));
    }

    /*Multiplication*/
    // http://localhost:8080/multiplication/10/5
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.multiplication(converteToDouble(numberOne), converteToDouble(numberTwo));
    }

    /*Division*/
    // http://localhost:8080/division/10/5
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{

            if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a numeric value!");
            }
            if(converteToDouble(numberTwo) == 0){
                throw new UnsupportedMathOperationException("Division by zero is not allowed!");
            }
            return math.division(converteToDouble(numberOne), converteToDouble(numberTwo));
    }

    /*Mean*/
    // http://localhost:8080/mean/10/5
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

            if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a numeric value!");
            }
            return math.mean(converteToDouble(numberOne), converteToDouble(numberTwo));
    }

    /*Square Root*/
    // http://localhost:8080/squareRoot/9
    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number") String number
    )throws Exception{

                if(!isNumeric(number)){
                    throw new UnsupportedMathOperationException("Please set a numeric value!");
                }
                return math.squareRoot(converteToDouble(number));
    }


}
