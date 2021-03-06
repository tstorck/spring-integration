/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.dsl.channel;

import org.springframework.integration.channel.DirectChannel;

/**
 * @author Artem Bilan
 *
 * @since 5.0
 */
public class DirectChannelSpec extends LoadBalancingChannelSpec<DirectChannelSpec, DirectChannel> {

	@Override
	protected DirectChannel doGet() {
		this.channel = new DirectChannel(this.loadBalancingStrategy);
		if (this.failover != null) {
			this.channel.setFailover(this.failover);
		}
		if (this.maxSubscribers != null) {
			this.channel.setMaxSubscribers(this.maxSubscribers);
		}
		return super.doGet();
	}

	DirectChannelSpec() {
		super();
	}

}
