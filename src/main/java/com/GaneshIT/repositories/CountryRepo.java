package com.GaneshIT.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GaneshIT.model.CountryMasterEntity;

@Repository
public interface CountryRepo extends JpaRepository<CountryMasterEntity, Serializable>{

}
