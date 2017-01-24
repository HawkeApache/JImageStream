package pl.edu.uj.JImageStream.tests.filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.junit.Test;
import pl.edu.uj.JImageStream.collectors.BufferedImageCollector;
import pl.edu.uj.JImageStream.filters.arithmetic.MultiplyImageFilter;
import pl.edu.uj.JImageStream.tests.AbstractBaseTest;

public class MultiplyImageFilterTest extends AbstractBaseTest {
    @Test
    public void multiplyImageFilterTest() {

        BufferedImage carBufferedImage = streamableImage2.stream().collect(new BufferedImageCollector());

        // tag::MultiplyImageFilter[]
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new MultiplyImageFilter(carBufferedImage))
                .collect(new BufferedImageCollector());
        // end::MultiplyImageFilter[]

        try {
            ImageIO.write(bufferedImage, "png", new File("target/docs/images/MultiplyImageFilter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
