package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;

public class VolumePlugin extends Plugin {
    @Override
    public PluginAction[] getActions() {
        return new PluginAction [] {new VolumeAction(getHome())};
    }
}