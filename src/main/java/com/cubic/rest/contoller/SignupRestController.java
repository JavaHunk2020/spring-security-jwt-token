package com.cubic.rest.contoller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.dto.MessageResponse;
import com.cubic.dto.SignupDTO;
import com.cubic.service.SignupService;


@RestController  //@Controller +@ResponseBody
@RequestMapping("/v2")
@CrossOrigin(origins = "*")
public class SignupRestController {
	
	/*
	 * @PostMapping("/auth") public SignupDTO authPost(@RequestBody AuthDTO authDTO)
	 * { SignupDTO
	 * signup=signupService.findByUsernameAndPassword(authDTO.getUsername(),
	 * authDTO.getPassword()); return signup; }
	 */
	
	/**
	 * GET , POST , PUT , PATCH , DELETE
	 * URI
	 * URL
	 */

	@Autowired
	private SignupService signupService;

	//http://localhost:3039/signups?sid=12 - >> Passing data as a part of query string
	//http://localhost:3039/signups/12 //Passing data as a part of uri
	@DeleteMapping("/signups/{sid}")
	public MessageResponse deleteData(@PathVariable int sid) {
		// code to fetch data from database
		signupService.deleteById(sid);
		return createMessage("Hey! your resource is deleted succcessfully.");
	}
	
	//DRY - >> Do not repeat yourself
	/**
	 * 
	 * @param message
	 * @return
	 */
	private MessageResponse createMessage(String message) {
		MessageResponse messageResponse=new MessageResponse();
		messageResponse.setCode(1);
		messageResponse.setMessage(message);
		return messageResponse;
	}
	
	
	@PatchMapping("/signups/image")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponse updateImagePost(@RequestParam int sid,@RequestParam String newimage) {
		signupService.updateImage(sid , newimage );
		//show all the records
		return createMessage("Hey your images is updated succcessfully.");
	}
	

	//@RequestBody we use inside rest API - to read JSON data from incoming request body
	//and map with Java object - >> Jackson mapper
	@PostMapping("/signups")
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse postSignup(@RequestBody SignupDTO signup) {
		signupService.save(signup);
		return createMessage("You have signed up successfully.");
	}
	
	@PutMapping("/signups")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponse updateSignup(@RequestBody SignupDTO signup) {
		signupService.update(signup);
		return createMessage("You have updated data successfully.");
	}
	
	@PostMapping("/signups/changepassword")
	public Map<String,String> changepassword(@RequestParam String username) {
		boolean status = signupService.findByUsername(username);
		Map<String,String> response = new LinkedHashMap<>();
		response.put("username", username);
		response.put("status","success" );
		response.put("message", status ? 
				"Ahah username is ok!": "Hmmmm I am sorry , username does not exist!");
		return response; // this view name for JSP
	}
	
	@PatchMapping("/signups/changepassword")
	public Map<String,String> patchChangepassword(@RequestParam String username,@RequestParam String password) {
		signupService.updatePassword(username,password);
		Map<String,String> response = new LinkedHashMap<>();
		response.put("username", username);
		response.put("message","Password is updated sucessfully" );
		response.put("status","success" );
		return response; // this view name for JSP
	}
	
	
	@GetMapping("/signup")
	public SignupDTO editProfileImage(@RequestParam int sid) {
		SignupDTO signupDTO = signupService.findById(sid);
		return signupDTO; // this view name for JSP
	}
	
	@GetMapping("/signups/{sid}")
	public SignupDTO findOneProfile(@PathVariable int sid) {
		SignupDTO signup = signupService.findById(sid);
		return signup; // this view name for JSP
	}

	@GetMapping("/signups")
	public List<SignupDTO> showAllData() {
		List<SignupDTO> signups = signupService.findAll();
		return signups; // this view name for JSP
	}


}
