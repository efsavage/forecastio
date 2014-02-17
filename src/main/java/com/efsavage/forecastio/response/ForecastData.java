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
import java.util.Date;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The actual weather data.
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastData {

	private Date time;
	private String summary;
	private String icon;
	private Date sunriseTime;
	private Date sunsetTime;
	private BigDecimal moonPhase;
	private BigDecimal nearestStormDistance;
	private BigDecimal precipIntensity;
	private BigDecimal precipIntensityMax;
	private Date precipIntensityMaxTime;
	private BigDecimal precipIntensityError;
	private BigDecimal precipProbability;
	private String precipType;
	private BigDecimal temperature;
	private BigDecimal temperatureMin;
	private BigDecimal temperatureMinTime;
	private BigDecimal temperatureMax;
	private BigDecimal temperatureMaxTime;
	private BigDecimal apparentTemperature;
	private BigDecimal apparentTemperatureMin;
	private BigDecimal apparentTemperatureMinTime;
	private BigDecimal apparentTemperatureMax;
	private BigDecimal apparentTemperatureMaxTime;
	private BigDecimal dewPoint;
	private BigDecimal humidity;
	private BigDecimal windSpeed;
	private BigDecimal windBearing;
	private BigDecimal visibility;
	private BigDecimal cloudCover;
	private BigDecimal pressure;
	private BigDecimal ozone;

}
