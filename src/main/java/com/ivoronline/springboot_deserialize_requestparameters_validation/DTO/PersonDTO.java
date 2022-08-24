package com.ivoronline.springboot_deserialize_requestparameters_validation.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDTO {

  //PROPERTIES
  @NotNull (message = "Name Parameter is missing")   //Optional Message
  @NotBlank(message = "Name should not be empty"  )  //Optional Message
  public String  name;

  @NotNull(message = "Age Parameter is missing")     //Optional Message
  public Integer age;

  //SETTERS (Dor Deserialization from HTTP Request Parameters)
  public void setName(String  name) { this.name = name; }
  public void setAge (Integer age ) { this.age = age;   }

}
