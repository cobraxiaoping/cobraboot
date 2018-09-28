package com.cobra.boot.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuartzJob.class)
public abstract class QuartzJob_ {

	public static volatile SingularAttribute<QuartzJob, String> jobName;
	public static volatile SingularAttribute<QuartzJob, String> jobStatus;
	public static volatile SingularAttribute<QuartzJob, String> previousTime;
	public static volatile SingularAttribute<QuartzJob, String> nextTime;
	public static volatile SingularAttribute<QuartzJob, String> description;
	public static volatile SingularAttribute<QuartzJob, String> methodName;
	public static volatile SingularAttribute<QuartzJob, String> jobGroup;
	public static volatile SingularAttribute<QuartzJob, String> isConcurrent;
	public static volatile SingularAttribute<QuartzJob, String> springId;
	public static volatile SingularAttribute<QuartzJob, String> cronExpression;
	public static volatile SingularAttribute<QuartzJob, Integer> jobId;
	public static volatile SingularAttribute<QuartzJob, String> jobClass;
	public static volatile SingularAttribute<QuartzJob, String> startTime;

}

