package com.h3pro.api.test.pessoa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H3ApiTestPessoaRepository extends JpaRepository<H3ApiTestPessoaEntity, Long> {

		
	List<H3ApiTestPessoaEntity> findByAge(int age);
	
	List<H3ApiTestPessoaEntity> findByName(String name);
	
	
}
