Feature: Test the Register page
 @TC_01
    Scenario: User launch home page of an dsalgo project
    Given The user opens DS Algo portal link
    When The user clicks the "Get Started" button
    Then The user should be redirected to the home page
 @TC_02
  Scenario: The user is presented with error message for empty fields below Username textbox 
    Given The user opens Register Page 
    When The user clicks "Register" button with all fields empty 
    Then It should display an error "Please fill out this field." below Username textbox  

 @TC_03
  Scenario: The user is presented with error message for empty fields below Password textbox 
    Given The user opens Register Page 
    When  The user clicks "Register" button after entering username with other fields empty 
			 | username        |
			 | kamala@vimala  |
    Then It should display an error "Please fill out this field." below Password textbox 
    
  @TC_04
    Scenario: The user is presented with error message for empty fields below Password Confirmation textbox 
   	Given The user opens Register Page
    When The user clicks "Register" button after entering "username" and "password" with Password Confirmation field empty 
			 | 	 username      | password     |
			 | kamala@vimala | testpassword |
    Then It should display an error "Please fill out this field." below Password Confirmation textbox 
        
  
    @TC_05
    Scenario: The user is presented with error message for invalid username 
    Given The user opens Register Page 
    When The user enters a "username" with characters other than Letters, digits and "@/./+/-/_" 
				| username | password     | password confirmation |
				| &**&**&  | testpassword | testpassword          |
    Then It should display an error message "Please enter a valid username" 
    
    @TC_06
    Scenario:  The user is presented with error message for password mismatch 
    Given The user opens Register Page 
    When The user clicks "Register" button after entering valid "username" and different passwords in "password" and "password confirmation" fields 
	      | username     		| password     | password confirmation | 
	      | kamalamala          | testpassword | testpassword1   |  
    Then It should display an error message "password_mismatch:The two password fields didn’t match."  
    
     @TC_07
     Scenario:  The user is presented with error message for password with characters less than 8.
    Given The user opens Register Page
    When he user enters a valid "username" and "password" with characters less than 8.
	      | username     		| password | password confirmation | 
	      | kamalamala      | a1b2c3d  | a1b2c3d            | 
    Then It should display an error message "Password should contain at least 8 characters." 
    
     @TC_08  
    Scenario:  The user is presented with error message for password with only numbers 
    Given The user opens Register Page 
    When The user enters a valid "username" and "password" with only numbers 
      | username     	 	| password | password confirmation | 
      | kamalamala      | 12345678 |              12345678 | 
    Then It should display an error message "Password can’t be entirely numeric." 
    
    @TC_09 
   Scenario:  The user is succesfully able to register  
    Given The user opens Register Page 
    When The user enters a valid "username" and "password" and "password confirmation" 
      | username     | password    | password confirmation | 
      | kamalamala   | kamalamalav |kamalamalav      | 
    Then The user should be redirected to Homepage with the message "New Account Created. You are logged in as kamala@vimala"
   		
     @TC_10
   	Scenario: The user is able to signout from the registered page.
    Given The user is in the "Sign in" page.
    When The user clicks the "Sign Out" link.
    Then The user should be redirected to the homepage with the message "Logged out successfully".
