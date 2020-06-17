/**********************************************************************************************************************************
 -File Name         :   Movie Service Application
 -Author            :   Sandra Binoy
 -Creation Date     :   11-06-2020
 -Description       :   This class holds the main method and comes under the class path
 **********************************************************************************************************************************/


package com.cg.omts.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
