package com.api.gateway.poc.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Leave {

    private Integer leaveId;
    private String leaveType;

    private String takenLeaves;

    private String totalLeaves;

    private String balanceLeaves;

    public Leave(Integer leaveId, String leaveType, String takenLeaves, String totalLeaves, String balanceLeaves) {
        this.leaveId = leaveId;
        this.leaveType = leaveType;
        this.takenLeaves = takenLeaves;
        this.totalLeaves = totalLeaves;
        this.balanceLeaves = balanceLeaves;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getTakenLeaves() {
        return takenLeaves;
    }

    public void setTakenLeaves(String takenLeaves) {
        this.takenLeaves = takenLeaves;
    }

    public String getTotalLeaves() {
        return totalLeaves;
    }

    public void setTotalLeaves(String totalLeaves) {
        this.totalLeaves = totalLeaves;
    }

    public String getBalanceLeaves() {
        return balanceLeaves;
    }

    public void setBalanceLeaves(String balanceLeaves) {
        this.balanceLeaves = balanceLeaves;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", leaveType='" + leaveType + '\'' +
                ", takenLeaves='" + takenLeaves + '\'' +
                ", totalLeaves='" + totalLeaves + '\'' +
                ", balanceLeaves='" + balanceLeaves + '\'' +
                '}';
    }
}
