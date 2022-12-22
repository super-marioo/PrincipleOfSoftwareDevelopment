package com.traning.principleofsoftwaredevelopment.dry.problem._4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class AbstractionExample {

  interface CustomEntity {
    long getId();
  }

  interface DbRepository<E extends CustomEntity> {
    E save(E entity);

    E update(E entity);

    E get(Long id);
  }

  interface Validator<E extends CustomEntity, R extends DbRepository<E>> {
    boolean isValid(E entity, R repo);
  }

  interface RestEndpoint<
      E extends CustomEntity, T extends DbRepository<E>, K extends Validator<E, T>> {
    E getData(Long id);
  }

  @RequiredArgsConstructor
  abstract static class BasicService<
      E extends CustomEntity,
      T extends DbRepository<E>,
      K extends Validator<E, T>,
      B extends RestEndpoint<E, T, K>> {

    private final T repository;
    private final K validator;
    private final B restEndpoint;

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

  // ------------------------

  @Getter
  @AllArgsConstructor
  static class Person implements CustomEntity {
    private long id;
  }

  static class PersonRepository implements DbRepository<Person> {
    @Override
    public Person save(Person entity) {
      // logic...
      return entity;
    }

    @Override
    public Person update(Person entity) {
      // logic...
      return entity;
    }

    @Override
    public Person get(Long id) {
      // logic...
      return new Person(id);
    }
  }

  static class PersonValidator implements Validator<Person, PersonRepository> {
    @Override
    public boolean isValid(Person entity, PersonRepository repo) {
      // logic...
      return false;
    }
  }

  static class PersonEndpoint implements RestEndpoint<Person, PersonRepository, PersonValidator> {
    @Override
    public Person getData(Long id) {
      return new Person(id);
    }
  }

  static class PersonService
      extends BasicService<Person, PersonRepository, PersonValidator, PersonEndpoint> {
    public PersonService(PersonRepository repository, PersonValidator validator,
        PersonEndpoint restEndpoint) {
      super(repository, validator, restEndpoint);
    }
  }
}
