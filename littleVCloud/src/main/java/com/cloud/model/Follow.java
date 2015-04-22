package com.cloud.model;

import java.util.List;

public class Follow {
    private Integer followId;

    private Integer who;

    private Integer target;
    
   

	public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followid) {
        this.followId = followid;
    }

    public Integer getWho() {
        return who;
    }

    public void setWho(Integer who) {
        this.who = who;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}