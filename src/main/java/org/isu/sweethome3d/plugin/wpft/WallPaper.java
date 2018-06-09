package org.isu.sweethome3d.plugin.wpft;

/** gbFRtpBC6BvHoyYlSq6zOZiqRt8ynkj+P8i/TFWfjwo=
 * Created by Katya on 04.06.2018.
 */

        import java.io.Serializable;

        import javax.persistence.*;

@Entity
public class WallPaper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long volume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private Article article;

    @ManyToOne
    private Files files;

}
