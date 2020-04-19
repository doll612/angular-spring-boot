package com.techievibe.server.Pojos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataList<E> extends ArrayList<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7856388604703358554L;

	private List<E> list;

	private long count;

}
