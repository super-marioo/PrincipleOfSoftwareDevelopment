package com.traning.principleofsoftwaredevelopment.solid.problem.dependencyinversion;

import java.util.ArrayList;

public class Keyboard {
  UsbCable communicationMedium;
  ArrayList<String> keys;
  Windows10 supportedOs;
}

class UsbCable { }
class Windows10 { }

// how can we make this code less tight coupled ?
