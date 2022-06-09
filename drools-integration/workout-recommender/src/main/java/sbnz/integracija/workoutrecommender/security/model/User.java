package sbnz.integracija.workoutrecommender.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Getter
@Setter
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User implements UserDetails {

//	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "cust_seq_user")
//	@SequenceGenerator(name = "cust_seq_user", sequenceName = "cust_seq_user", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;

	@Column(name = "enabled")
    private boolean enabled;

	@Getter(AccessLevel.NONE)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
    	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    	inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

	public User() {
		super();
	}

	public User(String email, String password, String name, String surname) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.enabled = true;
	}

	public void addAuthorityToUser(Authority authority) {
		if(this.authorities == null) {
			this.authorities = new ArrayList<Authority>();
		}
		this.authorities.add(authority);
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
	public String getUsername() {
		return this.getEmail();
	}
	
}
