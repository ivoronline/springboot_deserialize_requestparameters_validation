package com.ivoronline.springboot_deserialize_requestparameters_validation.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDTO {

  //PROPERTIES
  @NotBlank(message = "Name is mandatory")
  public String  name;

  @NotNull
  public Integer age;

  //SETTERS (used for deserialization)
  public void setName(String  name) { this.name = name; }
  public void setAge (Integer age ) { this.age = age;   }

}
