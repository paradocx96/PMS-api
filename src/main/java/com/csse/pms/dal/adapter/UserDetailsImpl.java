package com.csse.pms.dal.adapter;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.csse.pms.dal.model.InternelUserModel;
import com.csse.pms.dal.model.SupplierModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	private String contactNo;
	private String address;
	private String location;
	private String status;

	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	

	public UserDetailsImpl(String id,String name,String email,String password,String contactNo, String address,String location,  String status,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
		this.status = status;
		this.authorities = authorities;
	}
	
	public UserDetailsImpl(String id,String name,String email,String password,String contactNo, String address,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl buildSupplier(SupplierModel supplier) {
		
		List<SimpleGrantedAuthority> authorities = supplier.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		
		return new UserDetailsImpl(  supplier.getId(),
												supplier.getName(), 
												supplier.getEmail(), 
												supplier.getPassword(), 
												supplier.getContactNo(), 
												supplier.getAddress(),
												supplier.getLocation(), 
												supplier.getStatus(),
												authorities);
	}
	
	public static UserDetailsImpl buildInternelUsers(InternelUserModel user) {
		
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		
		return new UserDetailsImpl( user.getId(),
									user.getName(), 
									user.getEmail(), 
									user.getPassword(), 
									user.getContactNo(), 
									user.getAddress(),
									authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (this == object) {
			return true;
		}
		
		if (object == null || getClass() != object.getClass()) {
			return false;	
		}
			
		UserDetailsImpl user = (UserDetailsImpl) object;
		
		return Objects.equals(id, user.id);
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

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getAddress() {
		return address;
	}

	public String getLocation() {
		return location;
	}

	public String getStatus() {
		return status;
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
