package org.isu.sweethome3d.plugin.hello;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.PieceOfFurniture;
import com.eteks.sweethome3d.plugin.PluginAction;

import javax.swing.*;
/* Внутренний класс VolumePlugin*/
public class VolumeAction extends PluginAction {
    private Home home;
    public VolumeAction(Home home) {
        putPropertyValue(Property.NAME, "Compute volume");
        putPropertyValue(Property.MENU, "Tools");
        // Enables the action by default
        setEnabled(true);
        this.home = home;
    }
    @Override
    public void execute() {
        float volumeInCm3 = 0;
        // Compute the sum of the volume of the bounding box of
        // each movable piece of furniture in home
        for (PieceOfFurniture piece : home.getFurniture()) {
            if (piece.isMovable()) {
                volumeInCm3 += piece.getWidth()
                        * piece.getDepth()
                        * piece.getHeight();
            }
        }

        // Display the result in a message box (\u00b3 is for 3 in supercript)
        String message = String.format(
                "The maximum volume of the movable furniture in home is %.2f m\u00b3.",
                volumeInCm3 / 1000000);
        JOptionPane.showMessageDialog(null, message);
    }
}

