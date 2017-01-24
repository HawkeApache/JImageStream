package pl.edu.uj.JImageStream.tests.filters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.junit.Test;
import pl.edu.uj.JImageStream.collectors.BufferedImageCollector;
import pl.edu.uj.JImageStream.filters.arithmetic.MultiplyImageFilter;
import pl.edu.uj.JImageStream.tests.AbstractBaseTest;

public class MultiplyImageFilterWithDisplacementTest extends AbstractBaseTest {
    @Test
    public void multiplyImageFilterWithDisplacementTest() {

        BufferedImage carBufferedImage = streamableImage2.stream().collect(new BufferedImageCollector());

        // tag::MultiplyFilterImageWithDisplacement[]
        BufferedImage bufferedImage = streamableImage.stream()
                .apply(new MultiplyImageFilter(carBufferedImage, 200, 200))
                .collect(new BufferedImageCollector());
        // end::MultiplyFilterImageWithDisplacement[]

        try {
            ImageIO.write(bufferedImage, "png", new File("target/docs/images/MultiplyImageFilterWithDisplacement.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
