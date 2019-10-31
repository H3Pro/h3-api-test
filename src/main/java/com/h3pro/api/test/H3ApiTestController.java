package com.h3pro.api.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h3pro.api.test.pessoa.H3ApiTestPessoaEntity;
import com.h3pro.api.test.pessoa.H3ApiTestPessoaRepository;

@RestController
public class H3ApiTestController {

	
	private H3ApiTestPessoaRepository pessoaRepository;
	
	@Autowired
	public H3ApiTestController(H3ApiTestPessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;		
	}
	
	
	@GetMapping("/test")
	public String welcome() {
		
		 String val = "Bem vindo essa são todas  as Pessoas: \n\r \n\r";
		 
		List<H3ApiTestPessoaEntity> listaPessoa = pessoaRepository.findAll(); 
		 
		 for (H3ApiTestPessoaEntity pessoa : listaPessoa) {
				val += pessoa.getName() + "(" + pessoa.getCode() + ")\n\r";
				val += ">> Idade: " + String.valueOf(pessoa.getAge()) + "\n\r";
				val += ">> Email: " + pessoa.getEmail() + "\n\r \n\r";	
		}
				 
		 return val;
	}
	
	
	@GetMapping("/test/{name}/name/")
	public String getCode(@PathVariable String name) {
		
		String val = "Ok essa é a lista de Pessoas:\n\r"; 
		
		List<H3ApiTestPessoaEntity> listaPessoa = pessoaRepository.findByName(name);
		
		for (H3ApiTestPessoaEntity pessoa : listaPessoa) {
			val += pessoa.getName() + "(" + pessoa.getCode() + ")\n\r";
			val += ">> Idade: " + String.valueOf(pessoa.getAge()) + "\n\r";
			val += ">> Email: " + pessoa.getEmail() + "\n\r \n\r";	
		}
		
		return val;
		
	}
	
	@GetMapping("/test/{age}/age/")
	public String getMaxAge(@PathVariable int age) {
		
		String val = "Ok essa é a lista de Pessoa com idade menor que " + String.valueOf(age) + " \n\r"; 
		
		List<H3ApiTestPessoaEntity> listaPessoa = pessoaRepository.findAll();
		
		for(Iterator<H3ApiTestPessoaEntity> pessoaIntera = listaPessoa.iterator();pessoaIntera.hasNext();) {
			
				H3ApiTestPessoaEntity pessoaAtual = pessoaIntera.next();
				
				if(pessoaAtual.getAge() < age ) {
					val += pessoaAtual.getName() + "(" + pessoaAtual.getCode() + ")\n\r";
					val += ">> Idade: " + pessoaAtual.getAge() + "\n\r";
					val += ">> Email: " + pessoaAtual.getEmail() + "\n\r \n\r";	
				}
				
			
		}
		
		return val;
		
	}
	
	@PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postPessoa(@RequestBody H3ApiTestPessoaEntity pessoaEntity,Model model) {
		H3ApiTestPessoaEntity val = pessoaRepository.save(pessoaEntity);
		 if (val != null) { 
			 return "Salvo: " + val.getName() + " (" + val.getCode() + ")" ;
		 }else{ 
			 return "Tente mais tarde";
		 }
	}
	
	
	
	
	
}
