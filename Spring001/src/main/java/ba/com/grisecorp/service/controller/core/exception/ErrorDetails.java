package ba.com.grisecorp.service.controller.core.exception;

import java.util.Date;

public class ErrorDetails 
{
	
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) 
	{
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() 
	{
		return timestamp;
	}

	public String getMessage() 
	{
		return message;
	}

	public String getDetails() 
	{
		return details;
	}
	
	@Override
	public String toString()
	{
		return this.timestamp.toString()+ "\nMessage = " + this.message +"\nDetails="+this.details;
	}
}
