package com.fmv.reg.misc.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ActivityResponseWrapper<T> implements Serializable {

	private static final long serialVersionUID = -1072811211196180252L;
	
	private String status;
	
	private String message;
	
	private T data;

}
