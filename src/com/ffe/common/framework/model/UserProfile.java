package com.ffe.common.framework.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserProfile extends AbstractDomain implements UserDetails{

	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserProfile [authorities=" + authorities + ", dn=" + dn
				+ ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", moneyFormatterId="
				+ moneyFormatterId + ", password=" + password + ", roleString="
				+ roleString + ", territoryId=" + territoryId + ", uniqueId="
				+ uniqueId + ", userid=" + userid + "]";
	}
	
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	public Collection<? extends GrantedAuthority> authorities ;
	public String password;
	public Long getMoneyFormatterId() {
		return moneyFormatterId;
	}
	public void setMoneyFormatterId(Long moneyFormatterId) {
		this.moneyFormatterId = moneyFormatterId;
	}
	public String dn ;
	public String firstName;
	public String lastName;
	public String email;
	public Long userid;
	public Long territoryId;
	public Long moneyFormatterId;
	public List<UserRoleAssoc> userRoleAssocs;
	
	/**
	 * @return the userRoleAssocs
	 */
	public List<UserRoleAssoc> getUserRoleAssocs() {
		return userRoleAssocs;
	}

	/**
	 * @param userRoleAssocs the userRoleAssocs to set
	 */
	public void setUserRoleAssocs(List<UserRoleAssoc> userRoleAssocs) {
		this.userRoleAssocs = userRoleAssocs;
	}
	public String uniqueId;
	public Long getTerritoryId() {
		return territoryId;
	}
	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return email;
	}
	public void setUsername(String username) {
		this.email = username;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private String roleString;
	
	
	/**
	 * @return the roleString
	 */
	public String getRoleString() {
		return roleString;
	}

	/**
	 * @param roleString the roleString to set
	 */
	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
