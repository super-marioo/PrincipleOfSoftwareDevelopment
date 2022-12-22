package com.traning.principleofsoftwaredevelopment.solid.problem.openclose._1;

import lombok.Data;

@Data
public class Computer {
  private String ram;
  private String cpu;
  private String keyboard;

  private String mouse;

  private String display;

  // logic ....

}

// we want to add new feature -> Speaker to hear sound -> what to do ?
