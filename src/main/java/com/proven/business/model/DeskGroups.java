package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_desktop_groups")
public class DeskGroups implements Serializable {
    @Id
    private String id;

    private String name;

    @Column(name = "is_remote_pc")
    private Integer isRemotePc;

    @Column(name = "desktop_kind")
    private Integer desktopKind;

    @Column(name = "life_cycle_state")
    private Integer lifeCycleState;

    @Column(name = "session_support")
    private Integer sessionSupport;

    @Column(name = "create_date")
    private Date createDate;

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
     * @return is_remote_pc
     */
    public Integer getIsRemotePc() {
        return isRemotePc;
    }

    /**
     * @param isRemotePc
     */
    public void setIsRemotePc(Integer isRemotePc) {
        this.isRemotePc = isRemotePc;
    }

    /**
     * @return desktop_kind
     */
    public Integer getDesktopKind() {
        return desktopKind;
    }

    /**
     * @param desktopKind
     */
    public void setDesktopKind(Integer desktopKind) {
        this.desktopKind = desktopKind;
    }

    /**
     * @return life_cycle_state
     */
    public Integer getLifeCycleState() {
        return lifeCycleState;
    }

    /**
     * @param lifeCycleState
     */
    public void setLifeCycleState(Integer lifeCycleState) {
        this.lifeCycleState = lifeCycleState;
    }

    /**
     * @return session_support
     */
    public Integer getSessionSupport() {
        return sessionSupport;
    }

    /**
     * @param sessionSupport
     */
    public void setSessionSupport(Integer sessionSupport) {
        this.sessionSupport = sessionSupport;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}