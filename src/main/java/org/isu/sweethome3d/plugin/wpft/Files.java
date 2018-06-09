package org.isu.sweethome3d.plugin.wpft;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Katya on 06.06.2018.
 */
@Entity
public class Files extends WallPaper implements Serializable {

    public Files() {
        setDate(new Date());
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Long number;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}