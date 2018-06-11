package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.model.Content;
import com.eteks.sweethome3d.model.TextureImage;

import java.awt.image.BufferedImage;

public class Texture implements TextureImage {

    protected Article article;
    protected ImageContent content;

    public Texture(Article article, BufferedImage image) {
        this.article = article;
        this.content = new ImageContent(image);
    }

    @Override
    public String getName() {
        System.out.println("Got Name");
        return article.toString();
    }

    @Override
    public Content getImage() {
        System.out.println("Got Image");
        return content;
    }

    @Override
    public float getWidth() {
        return 100.0f; // One meter
    }

    @Override
    public float getHeight() {
        BufferedImage image = content.getImage();
        int w=image.getWidth(), h=image.getHeight();
        return (float)Math.floor(getWidth()*h/w);
    }

    @Override
    public String getCreator() {
        return "DeKart";
    }
}
