package com.messias.via_cep.service;

import com.messias.via_cep.model.Codebeautify;
import com.messias.via_cep.model.DTO.CodebeautifyDTO;
import com.messias.via_cep.model.repository.CodebeautifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CodebeautifyService {
	@Autowired
	private CodebeautifyRepository codebeautifyRepository;

	public CodebeautifyService(CodebeautifyRepository codebeautifyRepository) {
		this.codebeautifyRepository = codebeautifyRepository;
	}

	public CodebeautifyDTO buscarCep() {
		RestTemplate restTemplate = new RestTemplate();
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		restTemplate = restTemplateBuilder.build();

		CodebeautifyDTO codebeautifyDTO = restTemplate.getForObject("https://viacep.com.br/ws/41219487/json/", CodebeautifyDTO.class);
		
		Codebeautify codebeautify = this.converte(codebeautifyDTO);
		this.registerCep(codebeautify);

		return codebeautifyDTO;
	}

	private void registerCep(Codebeautify codebeautify) {
		Thread thread = new Thread( () -> {
			codebeautifyRepository.save(codebeautify);
		});
		thread.start();
	}


	private Codebeautify converte(CodebeautifyDTO codebeautifyDTO) {
		Codebeautify codebeautify = new Codebeautify();

		codebeautify.setBairro(codebeautifyDTO.getBairro());
		codebeautify.setCep(codebeautifyDTO.getCep());
		codebeautify.setLogradouro(codebeautifyDTO.getLogradouro());
		codebeautify.setComplemento(codebeautifyDTO.getComplemento());
		codebeautify.setDdd(codebeautifyDTO.getDdd());
		codebeautify.setGia(codebeautifyDTO.getGia());
		codebeautify.setSiafi(codebeautifyDTO.getSiafi());
		codebeautify.setIbge(codebeautifyDTO.getIbge());
		codebeautify.setUf(codebeautifyDTO.getUf());
		codebeautify.setLocalidade(codebeautifyDTO.getLocalidade());

		return codebeautify;
	}
}
