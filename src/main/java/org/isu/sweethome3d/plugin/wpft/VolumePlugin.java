package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;
import org.hibernate.Session;

public class VolumePlugin extends Plugin {
    public  VolumePlugin(){
        super();
        if (session = null)
    }
    @Override
   public PluginAction[] getActions() {return new PluginAction [] {new VolumeAction(getHome())};    }

   public static Session session = null;
}