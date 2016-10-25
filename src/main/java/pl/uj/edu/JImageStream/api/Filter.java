package pl.uj.edu.JImageStream.api;

import pl.uj.edu.JImageStream.model.Pixel;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public abstract class Filter {
    
    private WritableRaster source;
    private WritableRaster output;

    void setSource(BufferedImage bufferedImage) {
        this.source = bufferedImage.copyData(null);
        this.output= bufferedImage.copyData(null);
    }

    void saveToImage(BufferedImage bufferedImage) {
        bufferedImage.setData(output);
    }

    public abstract void apply(int x, int y);

    protected void setPixel(int x, int y, Pixel pixel) {
        output.setPixel(x, y, pixel.getColors());
    }

    protected Pixel getPixel(int x, int y) {
        //todo alpha support, investigate when and where alpha chanel is present
        int[] pixel = source.getPixel(x, y, (int[]) null);
        return new Pixel(pixel[0], pixel[1], pixel[2], 255);
    }



}
