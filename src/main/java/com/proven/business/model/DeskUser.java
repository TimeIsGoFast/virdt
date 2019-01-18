package com.proven.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_t_desk_user")
public class DeskUser implements Serializable {
    @Id
    private Integer id;

    private String sid;

    private String upn;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    private String domain;

    @Column(name = "creat_date")
    private Date creatDate;

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
     * @return upn
     */
    public String getUpn() {
        return upn;
    }

    /**
     * @param upn
     */
    public void setUpn(String upn) {
        this.upn = upn == null ? null : upn.trim();
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return full_name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * @return domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain
     */
    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    /**
     * @return creat_date
     */
    public Date getCreatDate() {
        return creatDate;
    }

    /**
     * @param creatDate
     */
    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
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