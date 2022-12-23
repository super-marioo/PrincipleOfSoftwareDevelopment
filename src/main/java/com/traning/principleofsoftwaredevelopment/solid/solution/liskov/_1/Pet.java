package com.traning.principleofsoftwaredevelopment.solid.solution.liskov._1;

interface KnowsTricks {}

public abstract class Pet implements KnowsTricks {}

interface Sit extends KnowsTricks {
  void sit();
}

interface PlayDead extends KnowsTricks {
  void playDead();
}

class Dog extends Pet implements Sit, PlayDead {
  @Override
  public void sit() {
    System.out.println("Sit...waiting for treat");
  }

  @Override
  public void playDead() {
    System.out.println("Play Dead");
  }
}

class SuperCleverFish extends Pet implements PlayDead {
  @Override
  public void playDead() {
    System.out.println("Play Dead");
  }
}
