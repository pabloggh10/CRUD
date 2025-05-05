package com.upiiz.crud.services;

import com.upiiz.crud.models.TransaccionesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TransaccionesModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM transacciones",
                new BeanPropertyRowMapper<>(TransaccionesModel.class));
    }

    public TransaccionesModel findById(int id) {
        return jdbcTemplate.query("SELECT * FROM transacciones WHERE id_transaccion=?",
                new BeanPropertyRowMapper<>(TransaccionesModel.class),id)
                .stream().findFirst().orElse(new TransaccionesModel());

    }

    public List<TransaccionesModel> findTransaccionesCuentaBYId(int idCuenta) {
        return jdbcTemplate.query("SELECT * FROM transacciones WHERE id_cuenta = ?",
        new BeanPropertyRowMapper<>(TransaccionesModel.class), idCuenta);

    }

    public void save(TransaccionesModel transaccion) {
        jdbcTemplate.update(
                "INSERT INTO transacciones(id_cuenta, fecha, tipo, monto) VALUES (?, ?, ?, ?)",
                transaccion.getId_cuenta(),
                transaccion.getFecha(),
                transaccion.getTipo(),
                transaccion.getMonto()
        );
    }

    public void update(TransaccionesModel transaccion) {
        jdbcTemplate.update(
                "UPDATE transacciones SET id_cuenta=?, fecha=?, tipo=?, monto=? WHERE id_transaccion=?",
                transaccion.getId_cuenta(),
                transaccion.getFecha(),
                transaccion.getTipo(),
                transaccion.getMonto(),
                transaccion.getId_transaccion()
        );
    }

    public void deletetransaccion(int id) {
        jdbcTemplate.update("DELETE FROM transacciones WHERE id_transaccion=?", id);
    }


}

