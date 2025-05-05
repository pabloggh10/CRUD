package com.upiiz.crud.controllers;

import com.upiiz.crud.models.TransaccionesModel;
import com.upiiz.crud.services.TransaccionesService;
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
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @Autowired
    private CuentasService cuentasService;

    // Mostrar todas las transacciones

    @GetMapping("/transacciones")
    public String transacciones(Model model) {
        List<TransaccionesModel> transacciones = transaccionesService.findAll();
        model.addAttribute("transacciones", transacciones);
        return "listado-transacciones";
    }

    @GetMapping("/transacciones/cuentas/{id}")
    public String transaccionesCeuntas(Model model, @PathVariable int id) {
        List<TransaccionesModel> transaccionesModels = transaccionesService.findTransaccionesCuentaBYId(id);
        model.addAttribute("transacciones", transaccionesModels);
        return "listado-transacciones";
    }



    // Formulario para nueva transacción
    @GetMapping("/transacciones/new")
    public String mostrarFormularioTransaccion(Model model) {
        TransaccionesModel transaccion = new TransaccionesModel();
        List<CuentasModel> cuentas = cuentasService.findAll(); // Para el combo de cuentas
        model.addAttribute("transaccion", transaccion);
        model.addAttribute("cuentas", cuentas);
        return "agregar-transacciones";
    }

    // Guardar nueva transacción
    @PostMapping("/transacciones/guardar")
    public String guardarTransaccion(@ModelAttribute TransaccionesModel transaccion) {
        transaccionesService.save(transaccion);
        return "redirect:/transacciones";
    }

    // Mostrar formulario para eliminar
    @GetMapping("/transacciones/delete/{id}")
    public String mostrarFormularioEliminarTransaccion(@PathVariable int id, Model model) {
        TransaccionesModel transaccion = transaccionesService.findById(id);
        model.addAttribute("transaccion", transaccion);
        return "eliminar-transaccion";
    }

    // Eliminar transacción
    @PostMapping("/transacciones/delete")
    public String eliminarTransaccion(@ModelAttribute TransaccionesModel transaccion) {
        transaccionesService.deletetransaccion(transaccion.getId_transaccion());
        return "redirect:/transacciones";
    }

    // Formulario de edición
    @GetMapping("/transacciones/edit/{id}")
    public String mostrarFormularioEditarTransaccion(@PathVariable int id, Model model) {
        TransaccionesModel transaccion = transaccionesService.findById(id);
        List<CuentasModel> cuentas = cuentasService.findAll(); // Para seleccionar otra cuenta si se desea
        model.addAttribute("transaccion", transaccion);
        model.addAttribute("cuentas", cuentas);
        return "editar-transaccion";
    }

    // Editar transacción
    @PostMapping("/transacciones/edit")
    public String editarTransaccion(@ModelAttribute TransaccionesModel transaccion) {
        transaccionesService.update(transaccion);
        return "redirect:/transacciones";
    }
}

