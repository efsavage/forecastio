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

/**
 * Unit of measurement.
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 */
public enum ForecastUnit {

	/**
	 * Default (mostly non-metric) units.
	 */
	US,
	/**
	 * Use SI units.
	 */
	SI,
	/**
	 * Identical to {@link #SI}, except that windSpeed is in kilometers per
	 * hour.
	 */
	CA,
	/**
	 * Identical to {@link #SI}, except that windSpeed is in miles per hour, as
	 * in the {@link #US}. (This option is provided because adoption of SI in
	 * the UK has been inconsistent.)
	 */
	UK,
	/**
	 * Selects the relevant units automatically, based on geographic location.
	 * Note that this may not be useful for calls from servers.
	 */
	AUTO

}
