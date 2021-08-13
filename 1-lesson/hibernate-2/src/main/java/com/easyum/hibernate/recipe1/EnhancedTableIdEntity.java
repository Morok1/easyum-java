package com.easyum.hibernate.recipe1;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EnhancedTableIdEntity {
	
    @Id
    @GeneratedValue(generator="TableIdGen")
	@GenericGenerator(strategy="org.hibernate.id.enhanced.TableGenerator",name="TableIdGen",
			parameters = {
			@Parameter(name = "table_name", value = "enhanced_hibernate_sequences"),
            @Parameter(name = "segment_value", value = "id"),
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
