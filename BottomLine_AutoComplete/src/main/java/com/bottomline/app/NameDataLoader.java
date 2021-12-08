package com.bottomline.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bottomline.app.autocomplete.AutoCompleteService;
import com.bottomline.app.autocomplete.NameRepository;

@Component
public class NameDataLoader implements CommandLineRunner{

	@Autowired
	private NameRepository nameRepository;
	
	@Autowired
	private AutoCompleteService autoCompleteService;
	
	@Override
	public void run(String... args) throws Exception {
		List<String> names = nameRepository.findAllNames();
		autoCompleteService.init(names);
	}
}
