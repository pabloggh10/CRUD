package com.upiiz.crud.services;


import com.upiiz.crud.models.CuentasModel;
import com.upiiz.crud.repositories.CuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CuentasService implements CuentasRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CuentasModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM cuentas",
                new BeanPropertyRowMapper<>(CuentasModel.class));
    }

    @Override
    public CuentasModel findById(int id) {
        return jdbcTemplate.query("SELECT *FROM cuentas WHERE id_cuenta=?",
                new BeanPropertyRowMapper<>(CuentasModel.class), id)
                .stream().findFirst().orElse(new CuentasModel());
    }

    @Override
    public void save(CuentasModel cuenta) {
        jdbcTemplate.update(
                "INSERT INTO cuentas(titular, tipo_cuenta, saldo) VALUES (?, ?, ?)",
                cuenta.getTitular(), cuenta.getTipo_cuenta(), cuenta.getSaldo());
    }

    @Override
    public void update(CuentasModel cuenta) {
        jdbcTemplate.update(
                "UPDATE cuentas SET titular=?, tipo_cuenta=?, saldo=? WHERE id_cuenta=?",
                cuenta.getTitular(), cuenta.getTipo_cuenta(), cuenta.getSaldo(), cuenta.getId_cuenta());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM cuentas WHERE id_cuenta=?", id);

    }
}
