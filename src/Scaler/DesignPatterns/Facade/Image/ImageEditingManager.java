package Scaler.DesignPatterns.Facade.Image;

import Scaler.DesignPatterns.Facade.Image.services.*;

public class ImageEditingManager {

    private ImageEditingFacade imageEditingFacade;
    public ImageEditingManager(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        this.imageEditingFacade = new ImageEditingFacade(imageLoader, filterService, imageModifier, imageWriter, analyticsService);
    }

    public void editImage(String imagePath, String filterType, int brightness) {
        imageEditingFacade.editImage(imagePath, filterType, brightness);
    }
}