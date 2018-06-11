package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.model.Content;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageContent implements Content {
    protected BufferedImage image;

    public ImageContent (BufferedImage image) {
        System.out.println("Setup the content.");
        this.image = image;
    }

    protected ByteArrayOutputStream os = null;

    @Override
    public InputStream openStream() throws IOException {
        if (os == null) {
            os = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", os);
            System.out.println("Write bytes...");
        };
        InputStream fis = new ByteArrayInputStream(os.toByteArray());
        System.out.println("Out bytes...");
        return fis;
    }

    public BufferedImage getImage() {
        return image;
    }
}
