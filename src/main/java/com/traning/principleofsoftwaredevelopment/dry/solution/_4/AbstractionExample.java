package com.traning.principleofsoftwaredevelopment.dry.solution._4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class AbstractionExample {

  @Getter
  @AllArgsConstructor
  static class Person {
    private long id;
  }

  static class PersonRepository {
    public Person save(Person entity) {
      // logic...
      return entity;
    }

    public Person update(Person entity) {
      // logic...
      return entity;
    }

    public Person get(Long id) {
      // logic...
      return new Person(id);
    }
  }

  static class PersonValidator {
    public boolean isValid(Person entity, PersonRepository repo) {
      // logic...
      return false;
    }
  }

  static class PersonEndpoint {

    public Person getData(Long id) {
      return new Person(id);
    }
  }

  // since we have only one of such service, it is too early to make big complicated abstraction
  @RequiredArgsConstructor
  static class PersonService {
    private final PersonRepository repository;
    private final PersonValidator validator;
    private final PersonEndpoint restEndpoint;

    void importData(Long id) {
      var entity = restEndpoint.getData(id);
      if (validator.isValid(entity, repository)) {
        if (repository.get(id) == null) {
          repository.save(entity);
        } else {
          repository.update(entity);
        }
      }
    }
  }
}
