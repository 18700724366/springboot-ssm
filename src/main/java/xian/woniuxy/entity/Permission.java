package xian.woniuxy.entity;

import java.io.Serializable;
import java.util.List;

public class Permission implements Serializable {

    private List<Permission> children;
    private Permission parent;
    private Integer permissionId;

    private String permissionName;

    private Integer parentId;

    private String component;

    private String path;

    private String permissionType;

    private String permissionExpr;

    private static final long serialVersionUID = 1L;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    public String getPermissionExpr() {
        return permissionExpr;
    }

    public void setPermissionExpr(String permissionExpr) {
        this.permissionExpr = permissionExpr == null ? null : permissionExpr.trim();
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }
}