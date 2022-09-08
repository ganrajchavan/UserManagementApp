package com.GaneshIT.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GaneshIT.model.CityMasterEntity;

@Repository
public interface CityRepo extends JpaRepository<CityMasterEntity, Serializable>{

	public List<CityMasterEntity> findByStateId(Integer stateId);
}
