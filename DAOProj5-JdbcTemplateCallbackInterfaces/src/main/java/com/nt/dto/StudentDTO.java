package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
   private int sno;
   private String sname;
   private String sadd;
   private float avg;
}
