package com.revertescript.api.service;

import org.springframework.stereotype.Service;

import com.revertescript.functional.ReverteScriptManager;

@Service
public class ReverteScriptService {

	public String reverteScript(String script) {
		return ReverteScriptManager.reverse(script);
	}
}
