package Scaler.DesignPatterns.AbstractFactory.Document;

import Scaler.DesignPatterns.AbstractFactory.Document.parser.DocumentParser;
import Scaler.DesignPatterns.AbstractFactory.Document.parser.SpreadsheetDocumentParser;
import Scaler.DesignPatterns.AbstractFactory.Document.printer.DocumentPrinter;
import Scaler.DesignPatterns.AbstractFactory.Document.printer.SpreadsheetDocumentPrinter;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.DocumentProcessor;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.SpreadsheetDocumentProcessor;

public class SpreadsheetDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    @Override
    public DocumentParser createDocumentParser(String path) {
        return new SpreadsheetDocumentParser(path);
    }

    @Override
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor) {
        return new SpreadsheetDocumentPrinter(processor);
    }

    @Override
    public DocumentProcessor createDocumentProcessor(String documentName) {
        return new SpreadsheetDocumentProcessor(documentName);
    }
}
