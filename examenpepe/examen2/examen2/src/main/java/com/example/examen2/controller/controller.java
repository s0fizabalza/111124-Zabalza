package com.example.examen2.controller

import java.util.Arraylist;
import com.example.examen2.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@controller
@RequestMapping

public class controller {
    Generator generator = new Generator();
    @GetMapping("/lista")
    @ResponseBody
    public String checklist(@RequestParam integer identificator){
        ArrayList<integer> lista = generator.generator();
        boolean checknum = false;
        if (lista.contains(identificator)) {
            checknum = true;
        }
        if (checknum == true){
            return "El numero" + indentificator + "se encuentra:" + lista;
        }
        else {
            return "El numero" + identificator + " no se encuentra:" + lista;
        }

    }

    Promedio promedio = new Promedio();
    @GetMapping("/promedio")
    @ResponseBody
    public String checklist (@RequestParam interger identificator){

    }

}