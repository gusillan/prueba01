package com.pacoillan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pacoillan.objetos.Entidad;
import com.pacoillan.repositorio.EntidadRepositorio;

@Controller
public class EntidadController {
	
	@Autowired
	EntidadRepositorio repositorio;
	
	@RequestMapping("/index")
	public String inicio() {
		return "mainMenu";
	}

	@RequestMapping("/listaEntidades")
	public String listaEntidades(Model modelo) {
		
		List<Entidad> lista = repositorio.buscarTodas();
		modelo.addAttribute("listaEntidades",lista);
		return "listaEntidades";
	}
	@RequestMapping("/formularioEntidad")
	public String consultaEntidadPagina() {
		System.out.println("Aqui hemos llegado");
		return "formularioEntidad";
	}
}
