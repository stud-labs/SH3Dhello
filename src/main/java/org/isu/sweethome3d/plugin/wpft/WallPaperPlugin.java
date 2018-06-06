package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.plugin.PluginAction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class WallPaperPlugin extends com.eteks.sweethome3d.plugin.Plugin {
    public WallPaperPlugin() {
        super();
        if (session == null) createDefaultSession();
    }
    @Override
    public PluginAction[] getActions() {

        return new PluginAction [] {
                new WallAction(getHome()),
                new WallPaperAction(getHome())
        };
    }

    public static Session session = null;

    protected void createDefaultSession()
    {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        session = factory.openSession();
    }
}