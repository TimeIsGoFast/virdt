package com.proven.system.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_s_resource")
public class Resource implements Serializable {
    @Id
    private Integer id;

    /**
     * 资源名
     */
    private String reid;

    /**
     * 资源中文名
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private String enabled;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 修改者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    /**
     * 父资源ID
     */
    private Integer pid;

    /**
     * 资源值
     */
    private String value;

    /**
     * 是否叶子节点
     */
    private String leaf;

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
     * 获取资源名
     *
     * @return reid - 资源名
     */
    public String getReid() {
        return reid;
    }

    /**
     * 设置资源名
     *
     * @param reid 资源名
     */
    public void setReid(String reid) {
        this.reid = reid == null ? null : reid.trim();
    }

    /**
     * 获取资源中文名
     *
     * @return name - 资源中文名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源中文名
     *
     * @param name 资源中文名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取状态
     *
     * @return enabled - 状态
     */
    public String getEnabled() {
        return enabled;
    }

    /**
     * 设置状态
     *
     * @param enabled 状态
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改时间
     *
     * @return update_date - 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改时间
     *
     * @param updateDate 修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取修改者
     *
     * @return update_by - 修改者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改者
     *
     * @param updateBy 修改者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取父资源ID
     *
     * @return pid - 父资源ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父资源ID
     *
     * @param pid 父资源ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取资源值
     *
     * @return value - 资源值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置资源值
     *
     * @param value 资源值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取是否叶子节点
     *
     * @return leaf - 是否叶子节点
     */
    public String getLeaf() {
        return leaf;
    }

    /**
     * 设置是否叶子节点
     *
     * @param leaf 是否叶子节点
     */
    public void setLeaf(String leaf) {
        this.leaf = leaf == null ? null : leaf.trim();
    }
}