package juke.com.repository;

import juke.com.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

  CurrencyEntity findByCode(String code);
}