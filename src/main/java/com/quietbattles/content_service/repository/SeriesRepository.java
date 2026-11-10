
package com.quietbattles.content_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quietbattles.content_service.entity.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

}
