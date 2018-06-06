package org.isu.sweethome3d.plugin.wpft;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Katya on 06.06.2018.
 */
@Entity
public class Collection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    @ManyToOne
    private Producer producer;
}
