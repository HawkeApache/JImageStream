package pl.edu.uj.JImageStream.predicates;

import pl.edu.uj.JImageStream.model.ColorChannel;
import pl.edu.uj.JImageStream.model.Pixel;

import java.util.function.Predicate;

public class ColorRangePredicate implements Predicate<Pixel> {

    private int min;
    private int max;
    private ColorChannel channel;

    public ColorRangePredicate(int min, int max, ColorChannel channel) {
        this.min = min;
        this.max = max;
        this.channel = channel;
    }

    @Override
    public boolean test(Pixel pixel) {
        int color;
        switch (channel) {
            case RED:
                color = pixel.getRed();
                break;
            case GREEN:
                color = pixel.getGreen();
                break;
            case BLUE:
                color = pixel.getBlue();
                break;
            case ALPHA:
                color = pixel.getAlpha();
                break;
            default:
                throw new IllegalArgumentException();
        }

        return color >= min && color <= max;
    }
}
