package com.traning.principleofsoftwaredevelopment.solid.problem.liskov._1;

public abstract class Pet {
  public abstract void sit();
  public abstract void playDead();
}

class Dog extends Pet {
  @Override
  public void sit() {
    System.out.println("Sit...waiting for treat");
  }

  @Override
  public void playDead() {
    System.out.println("Play Dead");
  }
}


class SuperCleverFish extends Pet {
  @Override
  public void sit() {
    throw new RuntimeException("Unable to sit - no legs");
  }

  @Override
  public void playDead() {
    System.out.println("Play Dead");
  }
}
