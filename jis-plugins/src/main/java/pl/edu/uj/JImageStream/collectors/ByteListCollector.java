package pl.edu.uj.JImageStream.collectors;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.List;
import pl.edu.uj.JImageStream.api.core.Collector;


public class ByteListCollector implements Collector<List<Byte>> {
    @Override
    public List<Byte> collect(BufferedImage bufferedImage) {
        logger.info(this.getClass() + " successfully collected image");
        byte[] data = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
        List<Byte> list = new ArrayList<>();
        for (byte d : data) {
            list.add(d);
        }
        return list;
    }
}
