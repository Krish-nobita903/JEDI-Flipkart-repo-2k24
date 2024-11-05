package com.flipfit.bean;

import java.util.Date;

public class UserPlan {
    private String userId;
    private String userPlanId;
    private Date planEndDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPlanId() {
        return userPlanId;
    }

    public void setUserPlanId(String userPlanId) {
        this.userPlanId = userPlanId;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }
}
