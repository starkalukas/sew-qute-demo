package at.htl.control;

import at.htl.entity.Vehicle;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("vehicle")
public class VehicleResource {

    private List<Vehicle> vehicleList = List.of(
            new Vehicle("Opel", "Kadett"),
            new Vehicle("VW", "Käfer")
    );


    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance vehicle(List<Vehicle> vehicles);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getPage() {
        return Templates.vehicle(vehicleList);
    }
}
