package com.fmv.reg.misc.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ActivityReport implements Serializable {

    private String activityReportId;

    private String activityName;

    private String activityDescription;

}
