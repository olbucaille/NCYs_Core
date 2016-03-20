package Routing;
import static spark.Spark.*;

import Interfaces.IO_Bdd;
import Services.Configuration;

public class Main {
    public static void main(String[] args) {
    	port(9090);
    	
    	get("/hello/:name", (request, response) -> {
    	    return "Hello: " + request.params(":name");
    	});
    	
    	get("/configuration/all/:idConf", (request, response) -> {
    	    return Configuration.getAllConfiguration(request.params(":idConf"));
    	});
    }
}