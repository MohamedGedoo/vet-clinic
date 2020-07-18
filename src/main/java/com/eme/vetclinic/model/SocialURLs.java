package com.eme.vetclinic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Embeddable object representing SocialURLs.
 *
 * @author Mohamed Gad
 */

@Embeddable
public class SocialURLs {

	@Column(name = "facebook")
	private String faceBook;

	@Column(name = "instgram")
	private String instgram;

	@Column(name = "twitter")
	private String twitter;

	public String getFaceBook() {
		return faceBook;
	}

	public void setFaceBook(String faceBook) {
		this.faceBook = faceBook;
	}

	public String getInstgram() {
		return instgram;
	}

	public void setInstgram(String instgram) {
		this.instgram = instgram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

}
