package org.pdsr.master.repo;

import org.pdsr.master.model.region_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionTableRepository extends JpaRepository<region_table, String> {

}
