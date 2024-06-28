package Scaler.DesignPatterns.Facade.Image.services;

import Scaler.DesignPatterns.Facade.Image.models.Image;

public class ImageLoader {
    public Image loadImage(String imagePath) {
        return new Image();
    }
}