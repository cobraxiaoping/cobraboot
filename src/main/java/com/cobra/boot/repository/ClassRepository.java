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

import com.cobra.boot.entity.Class;


public interface ClassRepository extends JpaRepository<Class, Integer>, JpaSpecificationExecutor<Class> {

	public static class Executor {
		private ClassRepository repository;

		public Executor(ClassRepository repository) {
			this.repository = repository;
		}
		public Page<Class> findAll(final Class filter, Pageable pageable) {
			return repository.findAll(new Specification<Class>() {
				private static final long serialVersionUID = 1L;
				@Override
				public Predicate toPredicate(Root<Class> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}
					return cb.and(merge(
					));
				}
			}, pageable);
		}
		
		public List<Class> findAll(final Class filter) {
			return repository.findAll(new Specification<Class>() {
				private static final long serialVersionUID = 1L;
				@Override
				public Predicate toPredicate(Root<Class> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}
					return cb.and(merge(
					));
				}
			});
		}
	}
}
