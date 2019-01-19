package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_session")
public class Session implements Serializable {
    @Id
    private Integer id;

    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "logon_duration")
    private Integer logonDuration;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "exit_code")
    private String exitCode;

    @Column(name = "failure_date")
    private Date failureDate;

    @Column(name = "connection_state")
    private String connectionState;

    @Column(name = "connection_state_change_date")
    private Date connectionStateChangeDate;

    @Column(name = "life_cycle_state")
    private String lifeCycleState;
    
    @Column(name = "time_diff")
    private String timeDiff;

    @Column(name = "current_connection_id")
    private Integer currentConnectionId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "machine_id")
    private String machineId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    /**
     * @return start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return logon_duration
     */
    public Integer getLogonDuration() {
        return logonDuration;
    }

    /**
     * @param logonDuration
     */
    public void setLogonDuration(Integer logonDuration) {
        this.logonDuration = logonDuration;
    }

    /**
     * @return end_date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return exit_code
     */
    public String getExitCode() {
        return exitCode;
    }

    /**
     * @param exitCode
     */
    public void setExitCode(String exitCode) {
        this.exitCode = exitCode == null ? null : exitCode.trim();
    }

    /**
     * @return failure_date
     */
    public Date getFailureDate() {
        return failureDate;
    }

    /**
     * @param failureDate
     */
    public void setFailureDate(Date failureDate) {
        this.failureDate = failureDate;
    }

    /**
     * @return connection_state
     */
    public String getConnectionState() {
        return connectionState;
    }

    /**
     * @param connectionState
     */
    public void setConnectionState(String connectionState) {
        this.connectionState = connectionState == null ? null : connectionState.trim();
    }

    /**
     * @return connection_state_change_date
     */
    public Date getConnectionStateChangeDate() {
        return connectionStateChangeDate;
    }

    /**
     * @param connectionStateChangeDate
     */
    public void setConnectionStateChangeDate(Date connectionStateChangeDate) {
        this.connectionStateChangeDate = connectionStateChangeDate;
    }

    /**
     * @return life_cycle_state
     */
    public String getLifeCycleState() {
        return lifeCycleState;
    }

    /**
     * @param lifeCycleState
     */
    public void setLifeCycleState(String lifeCycleState) {
        this.lifeCycleState = lifeCycleState == null ? null : lifeCycleState.trim();
    }

    /**
     * @return current_connection_id
     */
    public Integer getCurrentConnectionId() {
        return currentConnectionId;
    }

    /**
     * @param currentConnectionId
     */
    public void setCurrentConnectionId(Integer currentConnectionId) {
        this.currentConnectionId = currentConnectionId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return machine_id
     */
    public String getMachineId() {
        return machineId;
    }

    /**
     * @param machineId
     */
    public void setMachineId(String machineId) {
        this.machineId = machineId == null ? null : machineId.trim();
    }

    /**
     * @return created_date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return modified_date
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

	public String getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}
    
    
}