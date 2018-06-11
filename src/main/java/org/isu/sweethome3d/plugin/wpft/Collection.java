package org.isu.sweethome3d.plugin.wpft;

import org.isu.sweethome3d.plugin.wpft.Producer;

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

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @ManyToOne
    private Producer producer;

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

}
