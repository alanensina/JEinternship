package com.example.jexperts.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer>{

	@Override
	public Integer convert(String texto) {
		
		texto = texto.trim();
		
		if(texto.matches("[0-9]+")) {
			return Integer.valueOf(texto);
		}
		
		return null;
	}
}