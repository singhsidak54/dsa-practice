package Scaler.DesignPatterns.AbstractFactory.Document.printer;

import Scaler.DesignPatterns.AbstractFactory.Document.DocumentType;
import Scaler.DesignPatterns.AbstractFactory.Document.processor.DocumentProcessor;

public class SpreadsheetDocumentPrinter extends DocumentPrinter {

    public SpreadsheetDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}