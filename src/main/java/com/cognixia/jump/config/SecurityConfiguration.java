package com.cognixia.jump.config;

public class SecurityConfiguration {
<<<<<<< Updated upstream
    
=======
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	
	// Authentication - who are you?
	@Bean
	protected UserDetailsService userDetailsService() {
		
		return userDetailsService;
	}
	
	// Authorization - what do you want?
	@Bean
	protected SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
		//	.antMatchers("/api/**").hasRole("USER") // have to be user role to access /hello
			
			.antMatchers("/api/appointments").permitAll()
			
			.antMatchers("/create/customer").permitAll()
			.antMatchers("/authenticate").permitAll() // allow anyone to create token
			//.anyRequest().authenticated()  //any other API in this project has to be authenticated (token or user info to access)
			.and()
				.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ); // tell spring security to NOT CREATE sessions
		
		// this request will go through many filters, make sure that the FIRST filter that is checked is
		// the filter for jwts, in order to make sure of that, the filter has to be checked before you check the 
		// username & password (filter)
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				 
		return http.build();
	}
	
	
	// Encoder -> method that will encode/decode all the user passwords
	@Bean
	protected PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	// load the encoder & user details service that are needed for spring security to do authentication
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder( encoder() );
		
		return authProvider;
	}
	
	// can autowire and access the authentication manager (manages authentication (login) of our project)
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
>>>>>>> Stashed changes
}
