/**
 * Copyright (C) 2010 Zhang, Guilin <guilin.zhang@hotmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.http4j.metrics;

/**
 * @author <a href="mailto:guilin.zhang@hotmail.com">Zhang, Guilin</a>
 */
public abstract class AbstractMetrics implements Metrics {

	protected Timer dnsTimer;
	protected Timer connectionTimer;
	protected Timer requestTimer;
	protected Timer responseTimer;
	protected Counter<Long> requestTrafficCounter;
	protected Counter<Long> responseTrafficCounter;

	protected AbstractMetrics() {
		dnsTimer = createTimer();
		connectionTimer = createTimer();
		requestTimer = createTimer();
		responseTimer = createTimer();
		requestTrafficCounter = createLongCounter();
		responseTrafficCounter = createLongCounter();
	}

	abstract protected Counter<Long> createLongCounter();

	abstract protected Timer createTimer();
	
	@Override
	public Timer getDnsTimer() {
		return dnsTimer;
	}

	public Timer getConnectionTimer() {
		return connectionTimer;
	}

	@Override
	public Timer getRequestTimer() {
		return requestTimer;
	}

	@Override
	public Timer getResponseTimer() {
		return responseTimer;
	}

	@Override
	public void reset() {
		dnsTimer.reset();
		connectionTimer.reset();
		requestTimer.reset();
		responseTimer.reset();
		requestTrafficCounter.reset();
		responseTrafficCounter.reset();
	}

	@Override
	public Counter<Long> getRequestTrafficCounter() {
		return requestTrafficCounter;
	}

	@Override
	public Counter<Long> getResponseTrafficCounter() {
		return responseTrafficCounter;
	}

}