package com.nttdata.aflamiSpringBoot.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;


@MappedSuperclass
@Data
public class AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3405795893766666378L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractModel other = (AbstractModel) obj;
        if (ID == null) {
            return other.ID == null;
        } else return ID.equals(other.ID);
    }
	
}
