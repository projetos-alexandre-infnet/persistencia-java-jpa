package br.edu.infnet.apppagamento.model.persistence;

import java.util.List;

public interface IDAO<T> {
    void save(T t);

    void update(T t);

    void delete(Integer id);

    T getById(Integer id);

    List<T> listAll();
}
