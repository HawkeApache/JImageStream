package pl.uj.edu.JImageStream.api.filters;

import pl.uj.edu.JImageStream.api.Filter;
import pl.uj.edu.JImageStream.model.Pixel;

public class SaltAndPepperFilter extends Filter {

    private double p;

    public SaltAndPepperFilter() {
        this.p = .2;
    }

    public SaltAndPepperFilter(double p) {
        this.p = p;
    }

    @Override
    public void apply(int x, int y) {
        int r;
        if (Math.random() < p) {
            if (Math.random() < 0.5) {
                r = 255;
            } else {
                r = 0;
            }
            setPixel(x, y, new Pixel(r, r, r, 255));

        }
    }
}
