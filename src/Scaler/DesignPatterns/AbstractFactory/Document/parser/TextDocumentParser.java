package Scaler.DesignPatterns.AbstractFactory.Document.parser;

import Scaler.DesignPatterns.AbstractFactory.Document.DocumentType;

public class TextDocumentParser extends DocumentParser {

    public TextDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}