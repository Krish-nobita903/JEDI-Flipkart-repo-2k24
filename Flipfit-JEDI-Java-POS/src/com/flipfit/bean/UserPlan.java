package com.flipfit.bean;

import java.util.Date;

public class UserPlan {
    private int userId;
    private int userPlanId;
    private Date planEndDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserPlanId() {
        return userPlanId;
    }

    public void setUserPlanId(int userPlanId) {
        this.userPlanId = userPlanId;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }
}
