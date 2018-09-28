package com.cobra.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cobra.boot.entity.QuartzJob;
import com.cobra.boot.services.QuartzJobService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzJobServiceImplTest {
	@Autowired
	private QuartzJobService quartzJobService;
	
	@Test
	public void findQuartzJob() {
		QuartzJob job = quartzJobService.findQuartzJobById(1);
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(job);
			System.out.println(json);
			QuartzJob readValue = mapper.readValue(json, QuartzJob.class);
			System.out.println(readValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
