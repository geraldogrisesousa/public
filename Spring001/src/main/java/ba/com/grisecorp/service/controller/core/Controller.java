package ba.com.grisecorp.service.controller.core;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ba.com.grisecorp.service.controller.core.exception.ErrorDetails;

public class Controller {
	private static final Logger logger = LogManager.getLogger(Controller.class);
	public ResponseEntity ResponseOk()
	{
	    	Response response =  new Response(200,"sucesso", null);
	        return new ResponseEntity<Response>(response, HttpStatus.OK );
	}
	
    public ResponseEntity ResponseOk(Object data)
    {
    	Response response =  new Response(200,"sucesso", data);
        return new ResponseEntity<Response>(response, HttpStatus.OK );
    }
    
    public ResponseEntity ResponseError(Exception ex)
    {
    	Response response =  new Response(500, ex.getMessage(), null);
    	this.Log(ex);
    	return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR );
    }
    
    private void Log(Exception ex)
    {
    	
    	Date dateError = new Date();
		ErrorDetails errorDetails = new ErrorDetails(dateError, ex.getMessage(), "");
    	logger.error("Exception: " + errorDetails.toString());
    }
}
