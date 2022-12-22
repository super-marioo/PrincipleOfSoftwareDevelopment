package com.traning.principleofsoftwaredevelopment.solid.problem.interfacesegregation;

import java.util.Set;

public interface ComputerInterface {
  long closeProgram(long programId);
  void turnOn();
  long runProgram(String... args);
  Set<String> scanDisk();
  void logIn();
  void pressKey(char key);
  void defragmentDisk();
  void turnOff();
}

// how can we segregate this interface ?
