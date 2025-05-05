package com.upiiz.crud.repositories;


import com.upiiz.crud.models.CuentasModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentasRepository {
    List<CuentasModel> findAll();
    CuentasModel findById(int id);
    void save(CuentasModel cuenta);
    void delete(int id);
    void update(CuentasModel cuenta);
}
