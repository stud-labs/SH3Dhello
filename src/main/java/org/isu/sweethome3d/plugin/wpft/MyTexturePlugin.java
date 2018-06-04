package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;

public class MyTexturePlugin extends Plugin {
    @Override
    public PluginAction[] getActions() {
        return new PluginAction [] {new MyTextureAction(getHome())};
    }
}
