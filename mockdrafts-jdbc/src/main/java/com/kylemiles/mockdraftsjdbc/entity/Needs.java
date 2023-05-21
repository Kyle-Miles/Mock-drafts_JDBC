package com.kylemiles.mockdraftsjdbc.entity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Needs {
	
	private Long needsPK;
	private Position position;

}
