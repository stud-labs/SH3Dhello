package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.PieceOfFurniture;
import com.eteks.sweethome3d.model.Wall;
import com.eteks.sweethome3d.plugin.PluginAction;

import javax.swing.*;

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
        java.util.Collection<Wall> walls =  home.getWalls();
        for (Wall w : walls) {
            w.setHeight(new Float(290.0));
        }
        String message = String.format(
                "WalPaper !! Success walls no: %d", walls.size());
        JOptionPane.showMessageDialog(null, message);
    }

}

