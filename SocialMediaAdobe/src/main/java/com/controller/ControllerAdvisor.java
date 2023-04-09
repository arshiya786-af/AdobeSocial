package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import com.exception.*;

@ControllerAdvice 
public class ControllerAdvisor extends ResponseEntityExceptionHandler  {
	

	@ExceptionHandler(BlankPostException.class)
    public ResponseEntity<Object> handleBlankPostException(BlankPostException i,WebRequest req)
    {
        
        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(NoLoggedUserFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(NoLoggedUserFoundException i,WebRequest req)
    {
        
        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(NoUserFoundException i,WebRequest req)
    {
        
        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoMessageFoundException.class)
    public ResponseEntity<Object> handleMesageNotFoundException(NoMessageFoundException i,WebRequest req)
    {
        
        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoFriendFoundException.class)
    public ResponseEntity<Object> handleFriendNotFoundException(NoFriendFoundException i,WebRequest req)
    {
        
        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MessageCannotBeEmptyException.class)
	public ResponseEntity<Object> handleMessageCannotBeEmptyException(MessageCannotBeEmptyException i,WebRequest req)
    {
        
        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(NoLikesFoundException.class)
	   public ResponseEntity<Object> handleLikesNotFoundException(NoLikesFoundException i,WebRequest req)
	   {
	       
	       return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(NoCommentFoundException.class)
	   public ResponseEntity<Object> handleCommentNotFoundException(NoCommentFoundException i,WebRequest req)
	   {
	       
	       return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
	   }
	   
	   
	   
	   
	   @ExceptionHandler(NoAdminFoundException.class)
	    public ResponseEntity<Object> handleAdminNotFoundException(NoAdminFoundException i,WebRequest req)
	    {
	        
	        return  new ResponseEntity<>(i.toString(),HttpStatus.NOT_FOUND);
	    }

}
