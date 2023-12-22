package com.company.base.endpoint.rest.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;

@RestController
public class BigSumController {

    @GetMapping("/big-sum")
    public String bigSum(@RequestParam("a") String a, @RequestParam("b") String b) {
        try {

            BigInteger bigA = new BigInteger(a);
            BigInteger bigB = new BigInteger(b);

            BigInteger result = bigA.add(bigB);

            return result.toString();
        } catch (NumberFormatException e) {

            return "Les paramètres 'a' et 'b' doivent être des entiers valides.";
        }
    }
}

