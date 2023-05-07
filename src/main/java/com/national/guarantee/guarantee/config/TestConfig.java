package com.national.guarantee.guarantee.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.national.guarantee.guarantee.entities.Branch;
import com.national.guarantee.guarantee.repositories.BranchRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private BranchRepository branchRepository;
	
	
	
	

	@Override
	public void run(String... args) throws Exception {
		Branch b1 = new Branch(null, 1, 123456, 5, new Date(), 123, "apresentou falha" );
		
		branchRepository.saveAll(Arrays.asList(b1));
		
	}
	
}
