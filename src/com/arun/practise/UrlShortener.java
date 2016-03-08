package com.arun.practise;

public class UrlShortener {
	String idToShortURL(int n) {
		// Map to store 62 possible characters
		char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
				.toCharArray();

		StringBuffer shorturl = new StringBuffer("");

		// Convert given integer id to a base 62 number
		while (n > 0) {
			// use above map to store actual character
			// in short url
			System.out.println("n=" + n + " n%62=" + n%62 + " map[n%62]=" + map[n%62]);
			shorturl.append(map[n % 62]);
			n = n / 62;
		}

		// Reverse shortURL to complete base conversion
		StringBuffer result = shorturl.reverse();

		return result.toString();
	}

	// Function to get integer ID back from a short url
	int shortURLtoID(char[] shortURL) {
		int id = 0; // initialize result

		// A simple base conversion logic
		for (int i = 0; i < shortURL.length; i++) {
			System.out.println("char c=" + shortURL[i] + " id=" + id);
			if ('a' <= shortURL[i] && shortURL[i] <= 'z')
				id = id * 62 + shortURL[i] - 'a';
			if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
				id = id * 62 + shortURL[i] - 'A' + 26;
			if ('0' <= shortURL[i] && shortURL[i] <= '9')
				id = id * 62 + shortURL[i] - '0' + 52;
			System.out.println("id=" + id);
		}
		return id;
	}

	public static void main(String[] args) {
		UrlShortener us = new UrlShortener();
		int n = 4011658;
		String shorturl = us.idToShortURL(n);
		System.out.println("Generated short url is " + shorturl);
		System.out.println("Id from url is "
				+ us.shortURLtoID(shorturl.toCharArray()));
	}
}
