package com.dtt.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import ug.daes.DAESService;
import ug.daes.PKICoreServiceException;
import ug.daes.Result;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;


@SpringBootApplication
public class OrganizationApplication {

	Logger logger = LoggerFactory.getLogger(OrganizationApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OrganizationApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {

		CloseableHttpClient httpClient = HttpClients.custom().build();

		HttpComponentsClientHttpRequestFactory requestFactory =
				new HttpComponentsClientHttpRequestFactory(httpClient);

		requestFactory.setConnectionRequestTimeout(300000);
		requestFactory.setConnectTimeout(300000);
		requestFactory.setReadTimeout(300000);

		return new RestTemplate(requestFactory);
	}

	@Bean
	public String signatureServiceInitialize() {
		try {
			Result result = DAESService.initPKINativeUtils();
			return result.toString();
		} catch (PKICoreServiceException e) {
			logger.error("Unexpected exception", e);
			return "";
		}

	}





}
