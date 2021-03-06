package com.easyum.hibernate.recipe1;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SequenceStyleIdEntity {
    @Id
    @GeneratedValue( generator="IdGen")
	@GenericGenerator(strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",name="IdGen",
			parameters = {
            @Parameter(name = "sequence_name", value = "seq_id_gen"),
			@Parameter(name = "optimizer", value = "pooled"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "10") 
            })

    public Long id;
    @Column
    public String field;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
