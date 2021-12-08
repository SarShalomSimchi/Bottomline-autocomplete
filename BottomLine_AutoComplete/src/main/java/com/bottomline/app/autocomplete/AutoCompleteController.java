package com.bottomline.app.autocomplete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autocomplete")
public class AutoCompleteController {
	
	@Autowired
	private AutoCompleteService autoCompleteService;

	@GetMapping("/{prefix}")
	public ResponseEntity<List<String>>  getAutoCompleteOptions(@PathVariable String prefix) {
		return new ResponseEntity<>(autoCompleteService.getAutoCompleteOptions(prefix), HttpStatus.OK);
	}
}
