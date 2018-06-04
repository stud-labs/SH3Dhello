package org.isu.sweethome3d.plugin.wpft;

/*http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/Content.html*/
//Content for files, images...
public interface Content
        extends java.io.Serializable{

    /*Returns an input stream to a content.
    Throws:
    java.io.IOException - If the input stream can't be opened.*/
    java.io.InputStream openStream()
            throws java.io.IOException;
}

