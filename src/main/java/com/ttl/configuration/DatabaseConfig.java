package com.ttl.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConfig {
	private String jdbcUrl;
	private String username;
	private String password;
	private String driverClass;
}
