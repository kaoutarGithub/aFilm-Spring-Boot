package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.aflamiSpringBoot.entity.AbstractModel;

public abstract class AbstractService<T extends AbstractModel> {
	protected abstract JpaRepository<T, Long> getRepository();
	public List<T> getList(){
		return getRepository().findAll();
	}
	public T getOne(Long ID) {
		return getRepository().findById(ID)
				.orElseThrow(()->new RuntimeException());
	}
	public T save(T entity) {
		return getRepository().save(entity);
	}
	public void delete(Long ID) {
		getRepository().deleteById(ID);
	}
	
}
