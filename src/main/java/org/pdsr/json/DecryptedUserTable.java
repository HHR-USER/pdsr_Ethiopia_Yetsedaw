package org.pdsr.json;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DecryptedUserTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean error;
	private String message;
	private json_user_table selected;
	private List<json_user_table> data;

	public DecryptedUserTable() {
	}
	
	public DecryptedUserTable(json_user_table selected) {
		this.selected = selected;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public json_user_table getSelected() {
		return selected;
	}

	public void setSelected(json_user_table selected) {
		this.selected = selected;
	}

	public List<json_user_table> getData() {
		return data;
	}

	public void setData(List<json_user_table> data) {
		this.data = data;
	}

	public String encrypt(final String KEY, final String ISS, final String AUD) {


		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		// We will sign our JWT with our ApiKey secret
		Key hmacKey;
		try {
			hmacKey = new SecretKeySpec(KEY.getBytes("UTF-8"), SignatureAlgorithm.HS256.getJcaName());
		} catch (UnsupportedEncodingException e) {
			hmacKey = null;
			e.printStackTrace();
		}

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder()
				.setIssuer(ISS)
				.setAudience(AUD)
				.setHeaderParam("typ", "JWT")
				.claim("data", selected)
				.signWith(signatureAlgorithm, hmacKey);

		// Builds the JWT and serializes it to a compact, URL-safe string

		final String jwt = builder.compact();

		return jwt;

	}

	public String encryptList(final String KEY, final String ISS, final String AUD) {


		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		// We will sign our JWT with our ApiKey secret
		Key hmacKey;
		try {
			hmacKey = new SecretKeySpec(KEY.getBytes("UTF-8"), SignatureAlgorithm.HS256.getJcaName());
		} catch (UnsupportedEncodingException e) {
			hmacKey = null;
			e.printStackTrace();
		}

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder()
				.setIssuer(ISS)
				.setAudience(AUD)
				.setHeaderParam("typ", "JWT")
				.claim("data", data)
				.signWith(signatureAlgorithm, hmacKey);

		// Builds the JWT and serializes it to a compact, URL-safe string

		final String jwt = builder.compact();

		return jwt;

	}

}
