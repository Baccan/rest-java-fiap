package fiap.scj.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fiap.scj.rest.model.Vehicle;

@Path("/vehicles")
public class VehicleResource {
	
	private static List<Vehicle> listaVeiculos = new ArrayList<Vehicle>();
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	public Response allVehicles() {
		if(listaVeiculos.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(listaVeiculos, MediaType.APPLICATION_JSON).build();
	}
	
	@Path("{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Vehicle oneVehicle(@PathParam("id") String id) {
		if (listaVeiculos.contains(id)){
			//return listaVeiculos;
		}
		return null;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response createVehicle(Vehicle vehicle) {
		listaVeiculos.add(vehicle);
		return Response.created(
				URI.create("/"+ vehicle.getId())
			).build();
	}
}
