package fiap.scj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/vehicles")
public class VehicleResource {
	
	@GET
	public String olaMundo() {
		return "Minha primeira aplicação REST";
	}
}
