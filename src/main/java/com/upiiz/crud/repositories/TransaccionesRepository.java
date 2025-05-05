package com.upiiz.crud.repositories;


import com.upiiz.crud.models.TransaccionesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionesRepository {
    List<TransaccionesModel> findAll();                     // Obtener todas las transacciones
    TransaccionesModel findById(int id);                    // Buscar una transacción por su ID
    List<TransaccionesModel> findByCuentaId(int idCuenta);  // Buscar transacciones por ID de cuenta
    void save(TransaccionesModel transaccion);              // Insertar nueva transacción
    void update(TransaccionesModel transaccion);            // Actualizar transacción existente
    void deleteById(int id);

}
