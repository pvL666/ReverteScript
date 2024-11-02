package com.revertescript.api.controller;

import com.revertescript.api.service.SQLUndoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reverte-script")
public class ReverteScriptController {

    final private SQLUndoService sqlUndoService;

    public ReverteScriptController(SQLUndoService sqlUndoService) {
        this.sqlUndoService = sqlUndoService;
    }

    @PostMapping
    public ResponseEntity<String> reverseScript(@RequestBody String script) {
        String reversedScript = sqlUndoService.reverteScript(script);

        return ResponseEntity.ok(reversedScript);
    }
}
