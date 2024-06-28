package Scaler.DesignPatterns.AbstractFactory.Document.printer;

import Scaler.DesignPatterns.AbstractFactory.Document.DocumentType;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.DocumentProcessor;

public abstract class DocumentPrinter {

    private final DocumentProcessor processor;

    public DocumentPrinter(DocumentProcessor processor) {
        this.processor = processor;
    }

    public DocumentProcessor getProcessor() {
        return processor;
    }

    public abstract void printDocument();

    public abstract DocumentType supportsType();

}