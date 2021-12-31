package app.core.repo;

import app.core.entities.Job;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository <Job, Long> {

	public List<Job> findByEndDate (LocalDate endDate);
	public List<Job> findByBetweenDates (LocalDate startDate, LocalDate endDate);
	
	
	
}
