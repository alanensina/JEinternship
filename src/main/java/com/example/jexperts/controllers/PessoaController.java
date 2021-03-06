package com.example.jexperts.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jexperts.domain.Pessoa;
import com.example.jexperts.domain.enums.UF;
import com.example.jexperts.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "/pessoa/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas", service.buscarTodos());
		return "/pessoa/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "/pessoa/cadastro";
		}

		service.salvar(pessoa);
		attr.addFlashAttribute("success", "Pessoa cadastrada com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", service.buscarPorId(id));
		return "pessoa/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "/pessoa/cadastro";
		}

		service.editar(pessoa);
		attr.addFlashAttribute("success", "Pessoa editada com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {

		// adicionar a validação se há algum subordinado antes de fazer a exclusão
		service.excluir(id);
		attr.addFlashAttribute("success", "Pessoa excluída com sucesso.");

		return "redirect:/pessoas/listar";
	}

	@GetMapping("/buscar/superior")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("pessoas", service.buscarPorSuperior(id));
		return "/pessoa/lista";
	}

	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

	@ModelAttribute("superiores")
	public List<Pessoa> getSuperiores() {
		return service.buscarTodos();
	}
}