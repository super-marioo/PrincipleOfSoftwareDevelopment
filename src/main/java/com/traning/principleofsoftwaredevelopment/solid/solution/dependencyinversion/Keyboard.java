package com.traning.principleofsoftwaredevelopment.solid.solution.dependencyinversion;

import java.util.List;

public class Keyboard {
  UsbCable communicationMedium;
  List<String> keys;
  OperationSystem supportedOs;
}

interface Communication {}

class UsbCable implements Communication {}

class Bluetooth implements Communication {}
// -------

interface OperationSystem {}

class Windows10 implements OperationSystem {}

class Linux implements OperationSystem {}

class IOs implements OperationSystem {}

// how can we make this code less tight coupled ?
