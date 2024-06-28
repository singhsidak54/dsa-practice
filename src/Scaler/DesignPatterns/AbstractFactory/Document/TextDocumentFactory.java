package Scaler.DesignPatterns.AbstractFactory.Document;

import Scaler.DesignPatterns.AbstractFactory.Document.parser.DocumentParser;
import Scaler.DesignPatterns.AbstractFactory.Document.parser.TextDocumentParser;
import Scaler.DesignPatterns.AbstractFactory.Document.printer.DocumentPrinter;
import Scaler.DesignPatterns.AbstractFactory.Document.printer.TextDocumentPrinter;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.DocumentProcessor;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.TextDocumentProcessor;

public class TextDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    @Override
    public DocumentParser createDocumentParser(String path) {
        return new TextDocumentParser(path);
    }

    @Override
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor) {
        return new TextDocumentPrinter(processor);
    }

    @Override
    public DocumentProcessor createDocumentProcessor(String documentName) {
        return new TextDocumentProcessor(documentName);
    }
}
