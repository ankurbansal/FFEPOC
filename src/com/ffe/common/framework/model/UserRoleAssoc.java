package com.ffe.common.framework.model;

public class UserRoleAssoc extends AbstractDomain{

	private Long userRoleAssocId;
	public Long getUserRoleAssocId() {
		return userRoleAssocId;
	}
	public void setUserRoleAssocId(Long userRoleAssocId) {
		this.userRoleAssocId = userRoleAssocId;
	}
	private  Long roleId;
	private  Role role;
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	private  UserProfile profile ;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
}
