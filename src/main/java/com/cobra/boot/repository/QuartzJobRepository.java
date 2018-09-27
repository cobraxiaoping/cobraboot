package com.cobra.boot.repository;

import static com.cobra.boot.repository.JpaSpecUtils.*;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cobra.boot.entity.QuartzJob;
import com.cobra.boot.entity.QuartzJob_;


public interface QuartzJobRepository extends JpaRepository<QuartzJob, Integer>, JpaSpecificationExecutor<QuartzJob> {

	public static class Executor {
		private QuartzJobRepository repository;

		public Executor(QuartzJobRepository repository) {
			this.repository = repository;
		}
		public Page<QuartzJob> findAll(final QuartzJob filter, Pageable pageable) {
			return repository.findAll(new Specification<QuartzJob>() {
				private static final long serialVersionUID = 1L;
				@Override
				public Predicate toPredicate(Root<QuartzJob> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}
					return cb.and(merge(
					));
				}
			}, pageable);
		}
		
		public List<QuartzJob> findAll(final QuartzJob filter) {
			return repository.findAll(new Specification<QuartzJob>() {
				private static final long serialVersionUID = 1L;
				@Override
				public Predicate toPredicate(Root<QuartzJob> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}
					return cb.and(merge(
							eq(cb, root.get(QuartzJob_.jobStatus), filter.getJobStatus())
					));
				}
			});
		}
	}
}
