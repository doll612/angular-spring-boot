package com.techievibe.server.searchSpec;

import lombok.Data;

@Data
public class SearchCriteria {

	// Represents the entity field name
	private String key;

	// Represents the parameter value
	private Object value;

	// Indicates the search operation, i.e. equality, match, comparison, etc.
	private SearchOperator operator;

	public SearchCriteria() {
	}

	public SearchCriteria(String key, Object value, SearchOperator operator) {
		this.key = key;
		this.value = value;
		this.operator = operator;
	}
}
