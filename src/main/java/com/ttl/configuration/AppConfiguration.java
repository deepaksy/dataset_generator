package com.ttl.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppConfiguration {
	private String theme;
	private String language;
	private boolean  autoUpdate;
	
	
}
