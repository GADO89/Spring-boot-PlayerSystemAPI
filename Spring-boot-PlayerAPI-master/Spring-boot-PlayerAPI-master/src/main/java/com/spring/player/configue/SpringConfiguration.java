package com.spring.player.configue;

import com.spring.player.model.Player;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class SpringConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] preventMethod = {HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};

        config.getExposureConfiguration()
                .forDomainType(Player.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod));
    }
}
