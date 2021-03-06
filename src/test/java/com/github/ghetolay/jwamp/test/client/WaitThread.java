/**
*Copyright [2012] [Ghetolay]
*
*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*/
package com.github.ghetolay.jwamp.test.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WaitThread extends Thread{
	
	protected static final Logger log = LoggerFactory.getLogger(TestClient.class);
	
	public boolean done = false;
	public long waitFor = 0;
	
	public WaitThread(long waitFor){
		this.waitFor = waitFor;
	}
	
	public synchronized void run(){
		try{
			wait(waitFor);
		}catch(Exception e){
			log.debug("WaitThread Exception",e);
			done = false;
		}
	}
}
