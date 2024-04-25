package org.Login.presentation.DTO;

import java.util.Objects;

public class UserDTO {
	
	private Integer Id;
	private String name;
	private String email;
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
	@Override
	public String toString() {
		return "UserDTO [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, email, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(email, other.email) && Objects.equals(name, other.name);
	}
	public UserDTO(Integer id, String name, String email) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
	}
	public UserDTO() {
		super();
	}
	
	

}
