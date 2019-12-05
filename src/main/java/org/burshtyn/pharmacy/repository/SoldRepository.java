package org.burshtyn.pharmacy.repository;

import org.burshtyn.pharmacy.entity.Preparation;
import org.burshtyn.pharmacy.entity.Sold;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldRepository extends BaseRepository<Sold> {

    /**
     * finds list of Sold by preparation
     */
    List<Sold> findByPreparation(Preparation preparation);
}