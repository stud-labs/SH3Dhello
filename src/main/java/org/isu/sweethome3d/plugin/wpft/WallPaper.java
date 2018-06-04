package org.isu.sweethome3d.plugin.wpft;

/**
 * Created by Katya on 04.06.2018.
 */

        import java.io.Serializable;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;

@Entity
public class WallPaper implements Serializable {

    public WallPaper() {
        this.login = "test";
    };

    /*
    public WallPaper(String login) {
        this.login = login;

    };
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}