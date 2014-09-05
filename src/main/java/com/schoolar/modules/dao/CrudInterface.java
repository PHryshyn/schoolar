package com.schoolar.modules.dao;

import java.util.List;

public interface CrudInterface<T, t> {

  //  public void add(T t);
  //  public void update(T t);
    public T getOne(int id);
    public void delete(int id);
    public List<T> getList();

}
