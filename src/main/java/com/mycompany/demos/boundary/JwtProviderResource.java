package com.mycompany.demos.boundary;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class JwtProviderResource {

  @Inject
  TokenUtils tokenUtils;

  @GET
  @Path("/hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "hello";
  }

  @GET
  @Path("/generate-jwt")
  @Produces(MediaType.TEXT_PLAIN)
  public String generateJwt() {
    HashMap<String, Long> timeClaims = new HashMap<>();
    String token = null;
    try {
      token = tokenUtils.generateTokenString("/jwtClaims.json", timeClaims);
    } catch (Exception ex) {
      Logger.getLogger(JwtProviderResource.class.getName()).log(Level.SEVERE, null, ex);
    }
    return token;
  }

}
