package org.burshtyn.pharmacy.repository;

import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.entity.Preparation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends BaseRepository<Availability> {

    /**
     * finds list of availability by preparation
     */
    List<Availability> findByPreparation(Preparation preparation);
}