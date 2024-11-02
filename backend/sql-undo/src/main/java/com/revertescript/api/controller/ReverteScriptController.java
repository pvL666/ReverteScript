package com.revertescript.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revertescript.api.service.ReverteScriptService;

@RestController
@RequestMapping("/reverte-script")
public class ReverteScriptController {

	final private ReverteScriptService reverteScriptService;

	public ReverteScriptController(ReverteScriptService reverteScriptService) {
		this.reverteScriptService = reverteScriptService;
	}

	@PostMapping
	public ResponseEntity<String> reverseScript(@RequestBody String script) {
		String reversedScript = reverteScriptService.reverteScript(script);

		return ResponseEntity.ok(reversedScript);
	}
}
