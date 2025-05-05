package com.upiiz.crud.controllers;

import com.upiiz.crud.models.CuentasModel;
import com.upiiz.crud.services.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Controller
public class CuentasController {

    @Autowired
    private CuentasService cuentasService;

    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        List<CuentasModel> cuentas = cuentasService.findAll();
        model.addAttribute("cuentas", cuentas);
        return "listado-cuentas";
    }

    @GetMapping("/cuentas/new")
    public String MostrarFormulariocuenta(Model model) {
        CuentasModel cuentas = new CuentasModel();
        model.addAttribute("cuentas", cuentas);
        return "agregar-cuentas";
    }

    @PostMapping("/cuentas/guardar")
    public String guardarCuenta(@ModelAttribute CuentasModel cuentas) {
        cuentasService.save(cuentas);
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/delete/{id}")
    public String mostrarFormularioEliminarCuenta(@PathVariable int id, Model model) {
        CuentasModel cuentas = cuentasService.findById(id);
        model.addAttribute("cuentas", cuentas);
        return "eliminar-cuenta";
    }

    @PostMapping("/cuentas/delete")
    public String eliminarCuenta(@ModelAttribute CuentasModel cuentas) {
        cuentasService.delete(cuentas.getId_cuenta());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/edit/{id}")
    public String mostrarFormularioEditarCuenta(@PathVariable int id, Model model) {
        CuentasModel cuentas = cuentasService.findById(id);
        model.addAttribute("cuentas", cuentas);
        return "editar-cuenta";
    }

    @PostMapping("cuentas/edit")
    public String editarCuenta(@ModelAttribute CuentasModel cuentas) {
        cuentasService.update(cuentas);
        return "redirect:/cuentas";
    }
}
