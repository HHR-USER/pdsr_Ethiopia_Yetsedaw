package org.pdsr.master.repo;

import java.util.List;

import org.pdsr.master.model.audit_audit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditAuditRepository extends JpaRepository<audit_audit, String> {

	@Query("select t FROM audit_audit t WHERE t.rec_complete IS NULL")
	List<audit_audit> findByPendingRecommendation();

	@Query("select t FROM audit_audit t WHERE t.data_sent=0 OR t.data_sent IS NULL")
	List<audit_audit> findByAuditsToPush();

	@Query("select t.audit_icdpm, count(t.audit_icdpm) FROM audit_audit t WHERE t.audit_death < 3 "
			+ "GROUP BY t.audit_icdpm ORDER BY count(t.audit_icdpm) DESC")
	List<String[]> findByTopPMCodesStillBirth(Pageable pageable);

	@Query("select t.audit_icdpm, count(t.audit_icdpm) FROM audit_audit t WHERE t.audit_death < 3 AND YEAR(t.audit_cdate)=:cyear "
			+ "GROUP BY t.audit_icdpm ORDER BY count(t.audit_icdpm) DESC")
	List<String[]> findByTopPMCodesStillBirth(@Param("cyear") Integer year, Pageable pageable);

	@Query("select t.audit_icdpm, count(t.audit_icdpm) FROM audit_audit t WHERE t.audit_death = 3 "
			+ "GROUP BY t.audit_icdpm ORDER BY count(t.audit_icdpm) DESC")
	List<String[]> findByTopPMCodesNeonatal(Pageable pageable);

	@Query("select t.audit_icdpm, count(t.audit_icdpm) FROM audit_audit t WHERE t.audit_death = 3 AND YEAR(t.audit_cdate)=:cyear "
			+ "GROUP BY t.audit_icdpm ORDER BY count(t.audit_icdpm) DESC")
	List<String[]> findByTopPMCodesNeonatal( @Param("cyear") Integer year, Pageable pageable);

}
