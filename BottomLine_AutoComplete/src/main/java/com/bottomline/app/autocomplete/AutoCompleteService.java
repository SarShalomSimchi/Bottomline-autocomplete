package com.bottomline.app.autocomplete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bottomline.app.autocomplete.core.Dictionary;

@Service
public class AutoCompleteService {
	
	private Dictionary dictionary;
	
	public void init(List<String> words) {
		dictionary = new Dictionary(words);
	}

	public List<String> getAutoCompleteOptions(String prefix) {
		return dictionary.autoComplete(prefix);
	}

}
