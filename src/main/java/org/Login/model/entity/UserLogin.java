package org.Login.model.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import org.Login.model.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class UserLogin implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer Id;
	private String name;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "created_at", nullable = false, updatable = false)
	 private Date createdAt;

	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "updated_at", nullable = true)
	 private Date updatedAt;

	
	
	
	
	
	public String getUserRole() {
		return userRole.getRole();
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserLogin() {
		super();
	}

	
	
	
	
	
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public UserLogin( String name, String email, String password, UserRole userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, email, name, password, userRole);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && userRole == other.userRole;
	}
	@Override
	public String toString() {
		return "UserLogin [Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password + ", userRole="
				+ userRole + "]";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
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
