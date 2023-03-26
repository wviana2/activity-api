package com.fmv.reg.misc.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;


@Entity
@Table(name = "ACTIVITY")
@Data
public class Activity implements Serializable {

	private static final long serialVersionUID = 7854231933066624020L;
	
	@Id
	@Column(name = "ACTIVITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal activityId; 
	
	@Column(name = "ACTIVITY_DESCRIPTION")
	private String activityDescription;
	
	@Type(type = "yes_no")
	@Column(name = "COMPLETE")
	private boolean complete;

}
