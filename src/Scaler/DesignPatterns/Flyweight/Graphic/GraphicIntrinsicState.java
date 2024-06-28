package Scaler.DesignPatterns.Flyweight.Graphic;

@IntrinsicState
public class GraphicIntrinsicState {
    private GraphicType type; // "text" or "image"
    private Image image; // Text content or image file path
    private int width, height; // Dimensions
    private String color;

    public GraphicIntrinsicState(GraphicType type, Image image, int width, int height, String color) {
        this.type = type;
        this.image = image;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public GraphicType getType() {
        return type;
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }
}
