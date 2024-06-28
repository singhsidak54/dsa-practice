package Scaler.DesignPatterns.Factory.Document;

public class DocumentProcessorFactory {

    public static DocumentProcessor createDocumentProcessor(DocumentType type, String documentName) {
        switch (type) {
            case TEXT:
                return new TextDocumentProcessor(documentName);
            case PRESENTATION:
                return new PresentationDocumentProcessor(documentName);
            case SPREAD_SHEET:
                return new SpreadsheetDocumentProcessor(documentName);
            default:
                return null;
        }
    }
}
