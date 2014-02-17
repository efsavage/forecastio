/*
 *  Copyright 2014 Eric F. Savage, code@efsavage.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.efsavage.forecastio;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.efsavage.forecastio.request.ForecastBlock;
import com.efsavage.forecastio.request.ForecastExtend;
import com.efsavage.forecastio.request.ForecastUnit;
import com.efsavage.forecastio.response.ForecastResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A client for consuming the Forecast.io API.
 * 
 * <a href="https://developer.forecast.io/docs/v2">API Documentation</a>
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 */
public class ForecastClient {

	ObjectMapper mapper = new ObjectMapper();

	private String apiKey;

	/**
	 * Constructs an instance, {@link #setApiKey(String)} will need to be called
	 * before issuing any requests.
	 */
	public ForecastClient() {
		// Empty constructor
	}

	/**
	 * Constructs instance with API key.
	 * 
	 * @param apiKey
	 *            The API key to use on requests.
	 */
	public ForecastClient(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Finds or creates a client for the specified API key.
	 * 
	 * @param apiKey
	 *            The API key to use on requests.
	 * @return An instance of ForcastClient.
	 */
	public static ForecastClient getInstance(final String apiKey) {
		return new ForecastClient(apiKey);
	}

	/**
	 * Returns the API key used on requests.
	 * 
	 * @return the API key used on requests.
	 */
	public String getApiKey() {
		return this.apiKey;
	}

	/**
	 * Sets the API key used on requests.
	 * 
	 * @param apiKey
	 *            the API key used on requests.
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Fetches data for a location and time.
	 * 
	 * @param latitude
	 *            The latitude component of the location, required.
	 * @param longitude
	 *            The longitude component of the location, required.
	 * @param time
	 *            The time to fetch data for, may be null.
	 * @return The weather response for the parameters specified.
	 * @throws IOException
	 *             If the API call was unsuccesful.
	 */
	public ForecastResponse fetch(final double latitude, final double longitude, final Date time) throws IOException {
		return fetch(new BigDecimal(latitude), new BigDecimal(longitude), time, null, null);
	}

	/**
	 * The full constructor will all options exposed. Fetches data for a
	 * location and time.
	 * 
	 * @param latitude
	 *            The latitude component of the location, required.
	 * @param longitude
	 *            The longitude component of the location, required.
	 * @param time
	 *            The time to fetch data for, may be null.
	 * @param units
	 *            The units to use in the response.
	 * @param extend
	 *            Data extension options.
	 * @param excludes
	 *            Data blocks to exclude.
	 * @return The weather response for the parameters specified.
	 * @throws IOException
	 *             If the API call was unsuccessful.
	 */
	public ForecastResponse fetch(BigDecimal latitude, BigDecimal longitude, Date time, ForecastUnit units, ForecastExtend extend, ForecastBlock... excludes) throws IOException {
		StringBuilder url = new StringBuilder();
		url.append("https://api.forecast.io/forecast/" + this.apiKey + "/" + latitude.toString() + "," + longitude.toString());
		if (time != null) {
			url.append("," + (time.getTime() / 1000));
		}
		boolean firstParam = true;
		if (units != null) {
			if (firstParam) {
				url.append('?');
				firstParam = false;
			} else {
				url.append('&');
			}
			url.append("units=" + units.name().toLowerCase());
		}
		if (extend != null) {
			if (firstParam) {
				url.append('?');
				firstParam = false;
			} else {
				url.append('&');
			}
			url.append("extend=" + extend.name().toLowerCase());
		}
		if (excludes != null && excludes.length > 0) {
			if (firstParam) {
				url.append('?');
				firstParam = false;
			} else {
				url.append('&');
			}
			url.append("exclude=");
			for (int i = 0; i < excludes.length; i++) {
				if (excludes[i] == null) {
					continue;
				}
				if (i > 0) {
					url.append(',');
				}
				url.append(excludes[i].name().toLowerCase());
			}
		}
		URLConnection urlConnection = new URL(url.toString()).openConnection();
		ForecastResponse response = this.mapper.readValue(urlConnection.getInputStream(), ForecastResponse.class);
		response.setCacheControl(urlConnection.getHeaderField("Cache-Control"));
		response.setExpires(urlConnection.getExpiration());
		response.setApiCalls(Integer.parseInt(urlConnection.getHeaderField("X-Forecast-API-Calls")));
		response.setResponseTime(Integer.parseInt(urlConnection.getHeaderField("X-Response-Time").replaceAll("ms", "")));
		return response;
	}

	/**
	 * Fetches data for a location at the current time.
	 * 
	 * @param latitude
	 *            The latitude component of the location, required.
	 * @param longitude
	 *            The longitude component of the location, required.
	 * @return The weather response for the parameters specified.
	 * @throws IOException
	 *             If the API call was unsuccesful.
	 */
	public ForecastResponse fetch(double latitude, double longitude) throws IOException {
		return fetch(new BigDecimal(latitude), new BigDecimal(longitude), null, null, null);
	}

}
