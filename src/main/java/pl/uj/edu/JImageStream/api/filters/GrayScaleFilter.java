package pl.uj.edu.JImageStream.api.filters;

import pl.uj.edu.JImageStream.api.Filter;
import pl.uj.edu.JImageStream.model.Pixel;

public class GrayScaleFilter extends Filter {
    @Override
    public void apply(int x, int y) {
        Pixel input = getPixel(x, y);
        int gray = (input.getRed() + input.getBlue() + input.getGreen()) / 3;
        setPixel(x, y, new Pixel(gray, gray, gray, 255));
    }
}
