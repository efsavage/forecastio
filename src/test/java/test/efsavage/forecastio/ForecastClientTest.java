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
package test.efsavage.forecastio;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ajah.logback.LogbackUtils;
import com.efsavage.forecastio.ForecastClient;
import com.efsavage.forecastio.request.ForecastUnit;
import com.efsavage.forecastio.response.ForecastResponse;

/**
 * Test {@link ForecastClient}.
 * 
 * @author <a href="http://efsavage.com">Eric F. Savage</a>, <a
 *         href="mailto:code@efsavage.com">code@efsavage.com</a>.
 */
@Slf4j
public class ForecastClientTest {

	private ForecastClient client;

	/**
	 * Logging setup.
	 */
	@Before
	public void setup() {
		LogbackUtils.bridge();
		this.client = ForecastClient.getInstance(System.getProperty("forecastApiKey"));
	}

	/**
	 * Tests a current weather report.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testClientNow() throws IOException {
		ForecastResponse response = this.client.fetch(53.430833, -2.960833);
		log.debug(response.toString());
	}

	/**
	 * Tests a past (10 days ago) weather report.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testClientPast() throws IOException {
		ForecastResponse response = this.client.fetch(53.430833, -2.960833, new Date(System.currentTimeMillis() - 864000000));
		log.debug(response.toString());
	}

	/**
	 * Tests a future (10 days hence) weather report.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testClientFuture() throws IOException {
		ForecastResponse response = this.client.fetch(53.430833, -2.960833, new Date(System.currentTimeMillis() + 864000000));
		log.debug(response.toString());
	}

	/**
	 * Tests a current weather report with {@link ForecastUnit#SI} units.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testSI() throws IOException {
		ForecastResponse response = this.client.fetch(new BigDecimal(53.430833), new BigDecimal(-2.960833), null, ForecastUnit.SI, null, null, null);
		Assert.assertEquals("si", response.getFlags().getUnits());
		log.debug(response.toString());
	}

	/**
	 * Tests a current weather report with {@link ForecastUnit#US} units.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testUS() throws IOException {
		ForecastResponse response = this.client.fetch(new BigDecimal(53.430833), new BigDecimal(-2.960833), null, ForecastUnit.US, null, null, null);
		Assert.assertEquals("us", response.getFlags().getUnits());
		log.debug(response.toString());
	}

	/**
	 * Tests a current weather report with {@link ForecastUnit#CA} units.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testCA() throws IOException {
		ForecastResponse response = this.client.fetch(new BigDecimal(53.430833), new BigDecimal(-2.960833), null, ForecastUnit.CA, null, null, null);
		Assert.assertEquals("ca", response.getFlags().getUnits());
		log.debug(response.toString());
	}

	/**
	 * Tests a current weather report with {@link ForecastUnit#UK} units.
	 * 
	 * @throws IOException
	 *             If the API call failed.
	 */
	@Test
	public void testUK() throws IOException {
		ForecastResponse response = this.client.fetch(new BigDecimal(53.430833), new BigDecimal(-2.960833), null, ForecastUnit.UK, null, null, null);
		Assert.assertEquals("uk", response.getFlags().getUnits());
		log.debug(response.toString());
	}

}
