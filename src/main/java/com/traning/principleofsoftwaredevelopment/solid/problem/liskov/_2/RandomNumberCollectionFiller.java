package com.traning.principleofsoftwaredevelopment.solid.problem.liskov._2;

import java.util.List;
import java.util.Set;

public class RandomNumberCollectionFiller {

  public void fill(List<Double> collection) {
    if(collection == null) {
      return;
    }

    collection.add(Math.random());
  }


  public void fill(Set<Double> collection) {
    if(collection == null) {
      return;
    }

    collection.add(Math.random());
  }
}
