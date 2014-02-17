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
package com.efsavage.forecastio.response;

import java.math.BigDecimal;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The top-level response from the API.
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

	private BigDecimal latitude;

	private BigDecimal longitude;

	@JsonProperty("timezone")
	private String timeZone;

	private int offset;

	private ForecastData currently;
	private ForecastDataList minutely;
	private ForecastDataList hourly;
	private ForecastDataList daily;
	private ForecastFlags flags;
	private ForecastAlert[] alerts;

	// Header-derived fields
	private String cacheControl;
	private long expires;
	private int apiCalls;
	private int responseTime;

}
