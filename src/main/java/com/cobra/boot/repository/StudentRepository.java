package com.cobra.boot.repository;

import static com.cobra.boot.repository.JpaSpecUtils.*;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cobra.boot.entity.Student;
import com.cobra.boot.entity.Student_;


/**
 * @author cobra
 *
 */
/**
 * @author cobra
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> { 
	public static class Executor {
		private StudentRepository repository;

		public Executor(StudentRepository repository) {
			this.repository = repository;
		}
		public Page<Student> findAll(final Student filter, Pageable pageable) {
			return repository.findAll(new Specification<Student>() {
				private static final long serialVersionUID = 1L;
				@Override
				public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}
					return cb.and(merge(
							eq(cb, root.get(Student_.id), filter.getId())
					));
				}
			}, pageable);
		}
		
		public List<Student> findAll(final Student filter) {
			return repository.findAll(new Specification<Student>() {
				private static final long serialVersionUID = 1L;
				@Override
				public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}
					return cb.and(merge(
					));
				}
			});
		}
	}
	

	/**
	 * 简单的联合查询返回Map
	 * @param cid
	 * @return
	 */
	@Query(value="SELECT s.id,s.age,c.name from table_student s LEFT JOIN table_class c on s.classid= c.id where s.id<:cid",nativeQuery=true)
	public List<Map<String,Object>> findStudentAndClass(@Param("cid")Integer cid);
}
