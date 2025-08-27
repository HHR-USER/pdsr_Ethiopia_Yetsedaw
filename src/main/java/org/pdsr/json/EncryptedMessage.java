package org.pdsr.json;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EncryptedMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String KEY = "pD5r_uN1C3f_aFR1Ca";
	private final String ISS = "http://olincgroup.com";
	private final String AUD = "http://olincgroup.com";

	private boolean error;
	private String message;
	private String jwt;

	public EncryptedMessage() {
	}

	public EncryptedMessage(boolean error, String message) {
		super();
		this.error = error;
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Object decrypt() {

		Key hmacKey;
		try {
			hmacKey = new SecretKeySpec(KEY.getBytes("UTF-8"), SignatureAlgorithm.HS256.getJcaName());
		} catch (UnsupportedEncodingException e) {
			hmacKey = null;
			e.printStackTrace();
		}

		Claims claims = Jwts.parser().setSigningKey(hmacKey).parseClaimsJws(jwt).getBody();

		return claims.get("dataset");

	}

	public String getKEY() {
		return KEY;
	}

	public String getISS() {
		return ISS;
	}

	public String getAUD() {
		return AUD;
	}
	
	

}
