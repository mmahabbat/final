package com.company;

import java.io.Serializable;

public class Request implements Serializable {

    private String actionName;
    private Object objectArgument;
    private String firstArgument;
    private String secondArgument;
    private String thirdArgument;

    public Request(String actionName, Object objectArgument, String firstArgument, String secondArgument, String thirdArgument) {
        this.actionName = actionName;
        this.objectArgument = objectArgument;
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.thirdArgument = thirdArgument;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Object getObjectArgument() {
        return objectArgument;
    }

    public void setObjectArgument(Object objectArgument) {
        this.objectArgument = objectArgument;
    }

    public String getFirstArgument() {
        return firstArgument;
    }

    public void setFirstArgument(String firstArgument) {
        this.firstArgument = firstArgument;
    }

    public String getSecondArgument() {
        return secondArgument;
    }

    public void setSecondArgument(String secondArgument) {
        this.secondArgument = secondArgument;
    }

    public String getThirdArgument() {
        return thirdArgument;
    }

    public void setThirdArgument(String thirdArgument) {
        this.thirdArgument = thirdArgument;
    }
}
