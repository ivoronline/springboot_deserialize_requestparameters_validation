package com.ivoronline.springboot_deserialize_requestparameters_validation.controllers;

import com.ivoronline.springboot_deserialize_requestparameters_validation.DTO.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

  //==================================================================
  // HELLO
  //==================================================================
  @ResponseBody
  @RequestMapping("Hello")
  String hello(@Valid PersonDTO personDTO) {
    return "Hello " + personDTO.name;
  }

  //==================================================================
  // HANDLE EXCEPTIONS
  //==================================================================
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public Map<String, String> handleExceptions(BindException exception) {

    //CREATE MAP FOR STORING ERRORS
    Map<String, String> errors = new HashMap<>();

    //ITERATE THROUGH ERRORS
    List<ObjectError> objectErrors = exception.getAllErrors();
    for(ObjectError objectError : objectErrors) {

      //GET ERROR
      FieldError fieldError   = (FieldError) objectError;
      String     fieldName    = fieldError.getField();
      String     errorMessage = fieldError.getDefaultMessage();

      //STORE ERROR
      errors.put(fieldName, errorMessage);

    }

    //RETURN ERRORS
    return errors;

  }

}
