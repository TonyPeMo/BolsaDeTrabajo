package com.exemple.controlador;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exemple.bean.Empresa;
import com.example.repository.BaseDatos;
import com.exemple.bean.Usuari;


@Controller
@RequestMapping("")
public class Controlador {
	
	BaseDatos bd = new BaseDatos();
	Usuari usuari;
	
	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("titulo","FORMULARIO DE ACCESO");
		return "login";
	}
	
	@PostMapping("/")
	public String login(Usuari usuario, Model model) {
		if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
			ArrayList<Empresa> Empresas = bd.getEmpresas();
			model.addAttribute("usuario", usuario);
			this.usuari = usuario;
			model.addAttribute("Empresas", Empresas);
			return "consulta";
		} else
			return "login";
	}
	
	@PostMapping("/insertar")
	public String insertar(Empresa empresa, Model model) {
		bd.inserta(empresa);
		ArrayList<Empresa> Empresas = bd.getEmpresas();
		model.addAttribute("usuario", this.usuari);
		model.addAttribute("Empresas", Empresas);
		return "consulta";
	}
	
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Empresa> Empresas = bd.getEmpresas();
		model.addAttribute("Empresas", Empresas);
		model.addAttribute("usuario", this.usuari);
		model.addAttribute("boton", "Inserta Empresa");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
	
	@GetMapping("/modificar/{id}")
	public String modiciar(@PathVariable int id, Model model) {
		Empresa empresas = bd.getEmpresa(id);
		ArrayList<Empresa> Empresas = bd.getEmpresas();
		model.addAttribute("Empresas", Empresas);
		model.addAttribute("Empresa", Empresa);
		model.addAttribute("usuario", this.usuari);
		model.addAttribute("boton", "Actualiza Empresa");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}
	
	@PostMapping("/insertar")
	public String modifcar(Empresa empresas, Model model) {
		bd.inserta(Empresa);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("Empresas", empresas);
		model.addAttribute("Empresa", null);
		model.addAttribute("usuario", this.usuari);
		model.addAttribute("boton", "Actualiza Empresa");
		model.addAttribute("action", "/inseretar");
		return "consulta";
	}
}