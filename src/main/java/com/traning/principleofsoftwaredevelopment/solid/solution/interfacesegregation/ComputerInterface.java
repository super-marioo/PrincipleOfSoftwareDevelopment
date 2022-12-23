package com.traning.principleofsoftwaredevelopment.solid.solution.interfacesegregation;

import java.util.Set;

public interface ComputerInterface {
  void turnOn();

  void turnOff();
}

interface KeyboardInterface {
  void pressKey(char key);
}

interface DiskInterface {
  Set<String> scanDisk();

  void defragmentDisk();
}

interface LogIn {
  void logIn();
}

interface ProgramInterface {
  long runProgram(String... args);

  long closeProgram(long programId);
}
