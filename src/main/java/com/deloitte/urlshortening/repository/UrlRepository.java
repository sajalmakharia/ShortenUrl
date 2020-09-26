package com.deloitte.urlshortening.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.urlshortening.model.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url,Long> {

}
