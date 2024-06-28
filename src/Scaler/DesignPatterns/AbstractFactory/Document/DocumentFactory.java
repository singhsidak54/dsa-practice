package Scaler.DesignPatterns.AbstractFactory.Document;

import Scaler.DesignPatterns.AbstractFactory.Document.parser.DocumentParser;
import Scaler.DesignPatterns.AbstractFactory.Document.printer.DocumentPrinter;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.DocumentProcessor;

public abstract class DocumentFactory {
    public abstract DocumentType supportsType();
    public abstract DocumentParser createDocumentParser(String path);
    public abstract DocumentPrinter createDocumentPrinter(DocumentProcessor processor);
    public abstract DocumentProcessor createDocumentProcessor(String documentName);
}