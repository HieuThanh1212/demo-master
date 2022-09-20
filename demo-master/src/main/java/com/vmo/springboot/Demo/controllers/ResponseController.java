package com.vmo.springboot.Demo.controllers;




import com.vmo.springboot.Demo.utilities.ResponeUltil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class ResponseController {
    protected static ResponeUltil responseUtil;

    static {
        responseUtil = new ResponeUltil();
    }
}
