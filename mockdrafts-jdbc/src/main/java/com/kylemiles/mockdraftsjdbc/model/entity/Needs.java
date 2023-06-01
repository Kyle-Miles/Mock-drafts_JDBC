package com.kylemiles.mockdraftsjdbc.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Needs {
	
	private Long needsPK;
	private Position position;

}
