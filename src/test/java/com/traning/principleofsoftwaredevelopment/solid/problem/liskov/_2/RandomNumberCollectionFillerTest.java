package com.traning.principleofsoftwaredevelopment.solid.problem.liskov._2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.traning.principleofsoftwaredevelopment.solid.problem.liskov._2.RandomNumberCollectionFiller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class RandomNumberCollectionFillerTest {

  private final RandomNumberCollectionFiller cut = new RandomNumberCollectionFiller();

  @Test
  public void givenArrayList_fill_shouldFillListWithNumber() {
    // given
    var numbersBacked = new ArrayList<Double>();

    // when
    cut.fill(numbersBacked);

    // then
    assertEquals(1, numbersBacked.size());
  }

  @Test
  public void givenLinkedList_fill_shouldFillListWithNumber() {
    // given
    var numbersBacked = new LinkedList<Double>();

    // when
    cut.fill(numbersBacked);

    // then
    assertEquals(1, numbersBacked.size());
  }

  @Test
  public void givenImmutableList_fill_shouldFillListWithNumber() {
    // given
    var numbersBacked = List.<Double>of();

    // when
    cut.fill(numbersBacked);

    // then
    assertEquals(1, numbersBacked.size());
  }

  @Test
  public void givenHashSet_fill_shouldFillListWithNumber() {
    // given
    var numbersBacked = new HashSet<Double>();

    // when
    cut.fill(numbersBacked);

    // then
    assertEquals(1, numbersBacked.size());
  }

  @Test
  public void givenTreeSetList_fill_shouldFillListWithNumber() {
    // given
    var numbersBacked = new TreeSet<Double>();

    // when
    cut.fill(numbersBacked);

    // then
    assertEquals(1, numbersBacked.size());
  }

  @Test
  public void givenImmutableSet_fill_shouldFillListWithNumber() {
    // given
    var numbersBacked = Set.<Double>of();

    // when
    cut.fill(numbersBacked);

    // then
    assertEquals(1, numbersBacked.size());
  }
}
