package com.nttdata.aflamiSpringBoot.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.nttdata.aflamiSpringBoot.entity.Personne;

public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		HttpMethod [] unsupportedActions = {HttpMethod.POST, HttpMethod.PUT,HttpMethod.DELETE};
		
		config.getExposureConfiguration()
		.forDomainType(Personne.class)
		.withItemExposure((metadata, httpdMethods) -> httpdMethods.disable(unsupportedActions))
		.withCollectionExposure((metadata, httpdMethods) -> httpdMethods.disable(unsupportedActions));
		
		 // call an internal helper method
        //exposeIds(config);
		
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(Class[]::new));
        //config.exposeIdsFor(AbstractModel.class);
        //config.exposeIdsFor(Personne.class);        
	}
	
	
	
	
	

}
