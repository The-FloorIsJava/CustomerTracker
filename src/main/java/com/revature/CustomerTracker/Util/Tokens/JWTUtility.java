package com.revature.CustomerTracker.Util.Tokens;

import com.revature.CustomerTracker.customer.Customer;
import com.revature.CustomerTracker.Util.Exceptions.InvalidTokenException;
import com.revature.CustomerTracker.Util.Exceptions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

@Component
public class JWTUtility {

    @Value("${jwt.secret}")
    private String secret;
    private byte[] lazySaltyBytes;

    @PostConstruct
    public void createLazySaltyBytes(){
        lazySaltyBytes = Base64.getEncoder().encode(
                Base64.getEncoder().encode(secret.getBytes())
        );
    }
    public String createToken(Customer customer) throws IOException {

        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(String.valueOf(customer.getCustomerId()))
                .setSubject(customer.getCustomerName())
                .setIssuer("customerTracker-cjester")
                .claim("tier", customer.getTier())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000 * 8))
                .signWith(new SecretKeySpec(lazySaltyBytes, "HmacSHA256"));

       return tokenBuilder.compact();

    }
    private Optional<Customer> parseToken(String token){

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(lazySaltyBytes)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return Optional.of(new Customer(Integer.parseInt(claims.getId()), claims.getSubject(), claims.get("tier").toString()));
    }

    public boolean isTokenValid(String token){
        if(token == null || token.trim().equals("")) return false;
        return parseToken(token).isPresent();
    }

    public Customer extractTokenDetails(String token){
        if(!isTokenValid(token)) {
            throw new UnauthorizedException("You've not logged in an established a token");
        }
        return parseToken(token).orElseThrow(InvalidTokenException::new);
    }


}
