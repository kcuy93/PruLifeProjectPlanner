package com.mobee.prulifeagentplanner;

/**
 * Created by Kevin on 8/11/2016.
 */
public class Agent {

    public Agent(String id, String firstName, String lastName, String middleName, String emailAddress, AGENT_TYPE agentType, boolean isActivated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.emailAddress = emailAddress;
        this.agentType = agentType;
        this.isActivated = isActivated;
    }

    public enum AGENT_TYPE{
        AGENT,
        UM,
        BM
    }

    public String id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String emailAddress;
    public AGENT_TYPE agentType;
    public boolean isActivated;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public AGENT_TYPE getAgentType() {
        return agentType;
    }

    public void setAgentType(AGENT_TYPE agentType) {
        this.agentType = agentType;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

}
