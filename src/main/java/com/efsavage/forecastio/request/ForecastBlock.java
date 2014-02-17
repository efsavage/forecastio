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
package com.efsavage.forecastio.request;

import com.efsavage.forecastio.response.ForecastResponse;

/**
 * Blocks that can be excluded from the response.
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 */
public enum ForecastBlock {

	/**
	 * Exclude the {@link ForecastResponse#getCurrently()} block.
	 */
	CURRENTLY,
	/**
	 * Exclude the {@link ForecastResponse#getMinutely()} block.
	 */
	MINUTELY,
	/**
	 * Exclude the {@link ForecastResponse#getHourly()} block.
	 */
	HOURLY,
	/**
	 * Exclude the {@link ForecastResponse#getDaily()} block.
	 */
	DAILY,
	/**
	 * Exclude the {@link ForecastResponse#getAlerts()} block.
	 */
	ALERTS,
	/**
	 * Exclude the {@link ForecastResponse#getFlags()} block.
	 */
	FLAGS

}
