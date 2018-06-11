package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.model.*;
import com.eteks.sweethome3d.plugin.PluginAction;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/* Внутренний класс WallPaperPlugin*/
public class WallPaperAction extends PluginAction {
    private Home home;
    public WallPaperAction(Home home) {
        putPropertyValue(Property.NAME, "Add a wallpaper");
        putPropertyValue(Property.MENU, "Tools");
        // Enables the action by default
        setEnabled(true);
        this.home = home;
    }
    @Override
    public void execute() {
        // Display the result in a message box (\u00b3 is for 3 in supercript)
        TextureDialog.execute(this);
        if (! isValid()) {
            JOptionPane.showMessageDialog(null, "Артикул обоев не выбран!");
            return;
        };

        texture = new Texture(article, textureImage);

        HomeTexture t = new HomeTexture(texture);

        java.util.Collection<Wall> walls =  home.getWalls();
        java.util.List<Selectable> sels = home.getSelectedItems();
        for (Wall w : walls) {
            if (sels.contains(w)) {
                System.out.println("Selected " + w);
                w.setRightSideTexture(t);
            }
        }
    }

    public String textQuery = null;
    public Article article = null;
    public BufferedImage textureImage = null;
    public Texture texture = null;

    public boolean isValid() {
        return article!=null && textureImage != null;
    }

}

