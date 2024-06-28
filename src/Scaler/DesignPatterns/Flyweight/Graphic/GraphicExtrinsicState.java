package Scaler.DesignPatterns.Flyweight.Graphic;


@ExtrinsicState
public class GraphicExtrinsicState {
    private int x, y; // Coordinates

    private GraphicIntrinsicState graphicIntrinsicState;

    public GraphicExtrinsicState(int x, int y, GraphicIntrinsicState graphicIntrinsicState) {
        this.x = x;
        this.y = y;
        this.graphicIntrinsicState = graphicIntrinsicState;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public GraphicIntrinsicState getGraphicIntrinsicState() {
        return this.graphicIntrinsicState;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setGraphicIntrinsicState(GraphicIntrinsicState graphicIntrinsicState) {
        this.graphicIntrinsicState = graphicIntrinsicState;
    }
}