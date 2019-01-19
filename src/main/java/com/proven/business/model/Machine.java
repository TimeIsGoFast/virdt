package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_machine")
public class Machine implements Serializable {
    @Id
    private String id;

    private String sid;

    private String name;

    @Column(name = "dns_name")
    private String dnsName;

    @Column(name = "lifecycle_state")
    private Integer lifecycleState;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "hosted_Machine_id")
    private String hostedMachineId;

    @Column(name = "hosting_server_name")
    private String hostingServerName;

    @Column(name = "hosted_machine_name")
    private String hostedMachineName;

    @Column(name = "is_assigned")
    private Integer isAssigned;

    @Column(name = "is_in_maintenance_mode")
    private Integer isInMaintenanceMode;

    @Column(name = "is_pending_update")
    private Integer isPendingUpdate;

    @Column(name = "agent_version")
    private String agentVersion;

    @Column(name = "associated_user_full_names")
    private String associatedUserFullNames;

    @Column(name = "associated_user_names")
    private String associatedUserNames;

    @Column(name = "associated_user_UPNs")
    private String associatedUserUpns;

    @Column(name = "current_registration_state")
    private Integer currentRegistrationState;

    @Column(name = "registration_state_change_date")
    private Date registrationStateChangeDate;

    @Column(name = "last_deregistered_code")
    private Integer lastDeregisteredCode;
    
    @Column(name = "last_deregistered_date")
    private Date lastDeregisteredDate;

    @Column(name = "current_power_state")
    private Integer currentPowerState;

    @Column(name = "current_session_count")
    private Integer currentSessionCount;

    @Column(name = "controller_dns_name")
    private String controllerDnsName;

    @Column(name = "powered_on_date")
    private Date poweredOnDate;

    @Column(name = "powered_state_change_date")
    private Date poweredStateChangeDate;

    @Column(name = "functional_level")
    private Integer functionalLevel;

    @Column(name = "failure_date")
    private Date failureDate;

    @Column(name = "windows_connection_setting")
    private Integer windowsConnectionSetting;

    @Column(name = "is_preparing")
    private Integer isPreparing;

    @Column(name = "fault_state")
    private Integer faultState;

    @Column(name = "os_type")
    private String osType;
    
    @Column(name = "desktop_group_id")
    private String desktopGroupId;

    @Column(name = "current_load_index_id")
    private String currentLoadIndexId;

    @Column(name = "catalog_id")
    private String catalogId;

    @Column(name = "hypervisor_id")
    private String hypervisorId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return dns_name
     */
    public String getDnsName() {
        return dnsName;
    }

    /**
     * @param dnsName
     */
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName == null ? null : dnsName.trim();
    }

    /**
     * @return lifecycle_state
     */
    public Integer getLifecycleState() {
        return lifecycleState;
    }

    /**
     * @param lifecycleState
     */
    public void setLifecycleState(Integer lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    /**
     * @return ip_address
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * @return hosted_Machine_id
     */
    public String getHostedMachineId() {
        return hostedMachineId;
    }

    /**
     * @param hostedMachineId
     */
    public void setHostedMachineId(String hostedMachineId) {
        this.hostedMachineId = hostedMachineId == null ? null : hostedMachineId.trim();
    }

    /**
     * @return hosting_server_name
     */
    public String getHostingServerName() {
        return hostingServerName;
    }

    /**
     * @param hostingServerName
     */
    public void setHostingServerName(String hostingServerName) {
        this.hostingServerName = hostingServerName == null ? null : hostingServerName.trim();
    }

    /**
     * @return hosted_machine_name
     */
    public String getHostedMachineName() {
        return hostedMachineName;
    }

    /**
     * @param hostedMachineName
     */
    public void setHostedMachineName(String hostedMachineName) {
        this.hostedMachineName = hostedMachineName == null ? null : hostedMachineName.trim();
    }

    /**
     * @return is_assigned
     */
    public Integer getIsAssigned() {
        return isAssigned;
    }

    /**
     * @param isAssigned
     */
    public void setIsAssigned(Integer isAssigned) {
        this.isAssigned = isAssigned;
    }

    /**
     * @return is_in_maintenance_mode
     */
    public Integer getIsInMaintenanceMode() {
        return isInMaintenanceMode;
    }

    /**
     * @param isInMaintenanceMode
     */
    public void setIsInMaintenanceMode(Integer isInMaintenanceMode) {
        this.isInMaintenanceMode = isInMaintenanceMode;
    }

    /**
     * @return is_pending_update
     */
    public Integer getIsPendingUpdate() {
        return isPendingUpdate;
    }

    /**
     * @param isPendingUpdate
     */
    public void setIsPendingUpdate(Integer isPendingUpdate) {
        this.isPendingUpdate = isPendingUpdate;
    }

    /**
     * @return agent_version
     */
    public String getAgentVersion() {
        return agentVersion;
    }

    /**
     * @param agentVersion
     */
    public void setAgentVersion(String agentVersion) {
        this.agentVersion = agentVersion == null ? null : agentVersion.trim();
    }

    /**
     * @return associated_user_full_names
     */
    public String getAssociatedUserFullNames() {
        return associatedUserFullNames;
    }

    /**
     * @param associatedUserFullNames
     */
    public void setAssociatedUserFullNames(String associatedUserFullNames) {
        this.associatedUserFullNames = associatedUserFullNames == null ? null : associatedUserFullNames.trim();
    }

    /**
     * @return associated_user_names
     */
    public String getAssociatedUserNames() {
        return associatedUserNames;
    }

    /**
     * @param associatedUserNames
     */
    public void setAssociatedUserNames(String associatedUserNames) {
        this.associatedUserNames = associatedUserNames == null ? null : associatedUserNames.trim();
    }

    /**
     * @return associated_user_UPNs
     */
    public String getAssociatedUserUpns() {
        return associatedUserUpns;
    }

    /**
     * @param associatedUserUpns
     */
    public void setAssociatedUserUpns(String associatedUserUpns) {
        this.associatedUserUpns = associatedUserUpns == null ? null : associatedUserUpns.trim();
    }

    /**
     * @return current_registration_state
     */
    public Integer getCurrentRegistrationState() {
        return currentRegistrationState;
    }

    /**
     * @param currentRegistrationState
     */
    public void setCurrentRegistrationState(Integer currentRegistrationState) {
        this.currentRegistrationState = currentRegistrationState;
    }

    /**
     * @return registration_state_change_date
     */
    public Date getRegistrationStateChangeDate() {
        return registrationStateChangeDate;
    }

    /**
     * @param registrationStateChangeDate
     */
    public void setRegistrationStateChangeDate(Date registrationStateChangeDate) {
        this.registrationStateChangeDate = registrationStateChangeDate;
    }

    /**
     * @return last_deregistered_date
     */
    public Date getLastDeregisteredDate() {
        return lastDeregisteredDate;
    }

    /**
     * @param lastDeregisteredDate
     */
    public void setLastDeregisteredDate(Date lastDeregisteredDate) {
        this.lastDeregisteredDate = lastDeregisteredDate;
    }

    /**
     * @return current_power_state
     */
    public Integer getCurrentPowerState() {
        return currentPowerState;
    }

    /**
     * @param currentPowerState
     */
    public void setCurrentPowerState(Integer currentPowerState) {
        this.currentPowerState = currentPowerState;
    }

    /**
     * @return current_session_count
     */
    public Integer getCurrentSessionCount() {
        return currentSessionCount;
    }

    /**
     * @param currentSessionCount
     */
    public void setCurrentSessionCount(Integer currentSessionCount) {
        this.currentSessionCount = currentSessionCount;
    }

    /**
     * @return controller_dns_name
     */
    public String getControllerDnsName() {
        return controllerDnsName;
    }

    /**
     * @param controllerDnsName
     */
    public void setControllerDnsName(String controllerDnsName) {
        this.controllerDnsName = controllerDnsName == null ? null : controllerDnsName.trim();
    }

    /**
     * @return powered_on_date
     */
    public Date getPoweredOnDate() {
        return poweredOnDate;
    }

    /**
     * @param poweredOnDate
     */
    public void setPoweredOnDate(Date poweredOnDate) {
        this.poweredOnDate = poweredOnDate;
    }

    /**
     * @return powered_state_change_date
     */
    public Date getPoweredStateChangeDate() {
        return poweredStateChangeDate;
    }

    /**
     * @param poweredStateChangeDate
     */
    public void setPoweredStateChangeDate(Date poweredStateChangeDate) {
        this.poweredStateChangeDate = poweredStateChangeDate;
    }

    /**
     * @return functional_level
     */
    public Integer getFunctionalLevel() {
        return functionalLevel;
    }

    /**
     * @param functionalLevel
     */
    public void setFunctionalLevel(Integer functionalLevel) {
        this.functionalLevel = functionalLevel;
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
     * @return windows_connection_setting
     */
    public Integer getWindowsConnectionSetting() {
        return windowsConnectionSetting;
    }

    /**
     * @param windowsConnectionSetting
     */
    public void setWindowsConnectionSetting(Integer windowsConnectionSetting) {
        this.windowsConnectionSetting = windowsConnectionSetting;
    }

    /**
     * @return is_preparing
     */
    public Integer getIsPreparing() {
        return isPreparing;
    }

    /**
     * @param isPreparing
     */
    public void setIsPreparing(Integer isPreparing) {
        this.isPreparing = isPreparing;
    }

    /**
     * @return fault_state
     */
    public Integer getFaultState() {
        return faultState;
    }

    /**
     * @param faultState
     */
    public void setFaultState(Integer faultState) {
        this.faultState = faultState;
    }

    /**
     * @return os_type
     */
    public String getOsType() {
        return osType;
    }

    /**
     * @param osType
     */
    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    /**
     * @return current_load_index_id
     */
    public String getCurrentLoadIndexId() {
        return currentLoadIndexId;
    }

    /**
     * @param currentLoadIndexId
     */
    public void setCurrentLoadIndexId(String currentLoadIndexId) {
        this.currentLoadIndexId = currentLoadIndexId == null ? null : currentLoadIndexId.trim();
    }

    /**
     * @return catalog_id
     */
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * @param catalogId
     */
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    /**
     * @return hypervisor_id
     */
    public String getHypervisorId() {
        return hypervisorId;
    }

    /**
     * @param hypervisorId
     */
    public void setHypervisorId(String hypervisorId) {
        this.hypervisorId = hypervisorId == null ? null : hypervisorId.trim();
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

	public Integer getLastDeregisteredCode() {
		return lastDeregisteredCode;
	}

	public void setLastDeregisteredCode(Integer lastDeregisteredCode) {
		this.lastDeregisteredCode = lastDeregisteredCode;
	}

	public String getDesktopGroupId() {
		return desktopGroupId;
	}

	public void setDesktopGroupId(String desktopGroupId) {
		this.desktopGroupId = desktopGroupId;
	}
    
}