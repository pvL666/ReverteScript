package com.sqlundo.api.service;

import com.sqlundo.api.model.Script;
import com.sqlundo.functional.SQLUndoManager;
import org.springframework.stereotype.Service;

@Service
public class SQLUndoService {

    public String undo(Script script) {
        return SQLUndoManager.undo(script.script());
    }
}
