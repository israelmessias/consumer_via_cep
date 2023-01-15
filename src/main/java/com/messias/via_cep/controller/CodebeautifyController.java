package com.messias.via_cep.controller;

import com.messias.via_cep.model.DTO.CodebeautifyDTO;
import com.messias.via_cep.service.CodebeautifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/cep")
@RestController
public class CodebeautifyController {
	@Autowired
	CodebeautifyService codebeautifyService;
	@GetMapping
	public ResponseEntity get(){
		var codebeautify = codebeautifyService.buscarCep();
		return new ResponseEntity(codebeautify, HttpStatus.CREATED);
	}
}
