package com.GaneshIT.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GaneshIT.model.StateMasterEntity;

@Repository
public interface StateRepo extends JpaRepository<StateMasterEntity, Serializable>{
	public List<StateMasterEntity> findByCountryId(Integer countryId);
}
