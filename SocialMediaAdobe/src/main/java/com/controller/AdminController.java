package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.*;
import com.model.*;

import com.exception.NoAdminFoundException;
import com.exception.NoCommentFoundException;
import com.exception.NoGroupFoundException;
import com.exception.NoPostFoundException;
import com.exception.NoUserFoundException;

@RestController
public class AdminController {
	
	@Autowired
	AdminDAO admindao;
	
	@Autowired
	ForumDAO forumdao;
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/addadmin")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		
		adminservice.addAdminService(admin);
		
		return new ResponseEntity<String>("Admin added successfully",HttpStatus.OK);
	}

	@GetMapping("/getallamin")
	public List<Admin> getalladmin(){
		return admindao.findAll();
	}
	
	@PatchMapping("/updateadmin")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
		adminservice.updateAdminService(admin);
		return new ResponseEntity<String>("Admin details updated",HttpStatus.OK);
	}

	@DeleteMapping("/deleteadmin")
	public ResponseEntity<String> deleteAdmin(@RequestBody Admin admin) {
		adminservice.deleteAdminService(admin);
		return new ResponseEntity<String>("Admin deleted",HttpStatus.OK);
	}
	
	@GetMapping("/findbyadminid/{id}")
	public Admin getAdmin(@PathVariable String id) throws NoAdminFoundException {
			Admin admin;
			admin = adminservice.getAdminService(id);
			return admin;
	}
	
	@GetMapping("/admingetallUsers")
	public List<Users> adminGetAllUsers(){
		return adminservice.adminGetAllUsersService();
		
	}
	
	@PostMapping("/adminaddusers")
	public ResponseEntity<String> adminAddUsers(@RequestBody Users users){
		adminservice.adminAddUsersService(users);
		
		return new ResponseEntity<String>("User Registered Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/admindeleteusers")
	public ResponseEntity<String> adminDeleteUsers(@RequestBody Users users) {
		adminservice.adminDeleteUsersService(users);

		return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
	}



    @PostMapping("/addForum")
    public ResponseEntity<String> addForum(@RequestBody Forum forum)throws NoAdminFoundException {
        try {
        adminservice.addForumService(forum);
        return new ResponseEntity<String>("Added Forum", HttpStatus.OK);
        }
        catch(NoAdminFoundException e)
        {
            throw new NoAdminFoundException("Not created by Admin or no Admin found");        
 
        }
    }

    @DeleteMapping("/deleteForum")
    public ResponseEntity<String> deleteForum(@RequestBody Forum forum) throws NoAdminFoundException{
        try {
            adminservice.deleteForumService(forum);
            return new ResponseEntity<String>("Forum deleted", HttpStatus.OK);
            }
            catch(NoAdminFoundException e)
            {
                throw new NoAdminFoundException("Not created by Admin or no Admin found");        
 
            }
    }
	@PatchMapping("/ApproveForum/{id}")
	public ResponseEntity<String> ApproveForum(@PathVariable String id)
	{
		

			Optional<Forum> vals = forumdao.findById(id);
			System.out.println(vals.get());
			vals.get().setStatus(Status.ACTIVE);
			forumdao.save(vals.get());
		
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	    @PostMapping("/blockcomment")
	    public ResponseEntity blockComment(@RequestBody Comment c) {
	        
	        try {
	            return adminservice.blockComment(c);
	        } catch (NoCommentFoundException e) {
	            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
	        }
	    }    
	    
	    @PostMapping("/blockpost")
	    public ResponseEntity blockPost(@RequestBody Post p) {
	        
	        try {
	            return adminservice.blockPost(p);
	        } catch (NoPostFoundException e) {
	            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
	        }
	    }    
	    
	    @PostMapping("/blockuser")
	    public ResponseEntity blockUser(@RequestBody Users u) {
	        
	        try {
	            return adminservice.blockUser(u);
	        }
	        catch (NoUserFoundException e) {
	            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
	        }
	    }
	    
	    //unblock
	    @PostMapping("/unblockcomment")
	    public ResponseEntity unblockComment(@RequestBody Comment c) {
	        
	        try {
	            return adminservice.unblockComment(c);
	        } catch (NoCommentFoundException e) {
	            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
	        }
	    }    
	    
	    @PostMapping("/unblockpost")
	    public ResponseEntity unblockPost(@RequestBody Post p) {
	        
	        try {
	            return adminservice.unblockPost(p);
	        } catch (NoPostFoundException e) {
	            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
	        }
	    }    
	    
	    @PostMapping("/unblockuser")
	    public ResponseEntity unblockUser(@RequestBody Users u) {
	        
	        try {
	            return adminservice.unblockUser(u);
	        }
	        catch (NoUserFoundException e) {
	            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
	        }
	    }
	    
	    
	}