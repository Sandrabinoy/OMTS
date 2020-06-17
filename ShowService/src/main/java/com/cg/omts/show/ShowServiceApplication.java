/**********************************************************************************************************************************
 -File Name         :   Show Service Application
 -Author            :   Sandra Binoy
 -Creation Date     :   11-06-2020
 -Description       :   This class holds the main method and comes under the class path
 **********************************************************************************************************************************/

package com.cg.omts.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShowServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowServiceApplication.class, args);
	}

}
