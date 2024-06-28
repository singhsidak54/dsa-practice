package Scaler.DesignPatterns.AbstractFactory.Document.printer;

import Scaler.DesignPatterns.AbstractFactory.Document.DocumentType;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.DocumentProcessor;

public class TextDocumentPrinter extends DocumentPrinter {

    public TextDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}