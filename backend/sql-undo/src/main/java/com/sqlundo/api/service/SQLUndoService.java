package com.sqlundo.api.service;

import com.sqlundo.api.model.QueryDTO;
import com.sqlundo.api.model.Script;
import com.sqlundo.functional.SQLUndoManager;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SQLUndoService {

    public List<QueryDTO> undo(Script script) {
        return SQLUndoManager.undo(script.script());
    }
}
