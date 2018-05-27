package org.isu.sweethome3d.plugin.hello;

/*Изображение используется как текстура.
http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/TextureImage.html*/
public interface TextureImage
        extends java.io.Serializable{
    java.lang.String getName();
    Content getImage();
    float getWidth();

}
