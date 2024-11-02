package com.revertescript.api.service;

import com.revertescript.functional.SQLUndoManager;
import org.springframework.stereotype.Service;

@Service
public class SQLUndoService {

    public String reverteScript(String script) {
        return SQLUndoManager.reverse(script);
    }
}
