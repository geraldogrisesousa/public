package ba.com.grisecorp.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class TesteController {

	@GetMapping(value = "/")
	public ResponseEntity<String> Listar()
	{
		try 
		{
			return new ResponseEntity("Ok",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity("Error",HttpStatus.BAD_REQUEST);
		}
	}
}