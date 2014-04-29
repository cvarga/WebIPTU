/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cvarga.regras;
 
/*
import javax.inject.Inject;

import org.ifsp.fw2.entidades.IPTU;
import org.jboss.logging.Logger;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

public class RegrasController {

    @Inject
    @KSession("SessaoIPTU")
    KieSession kSession;
    

    public void execRegrasIPTUResidencial (final IPTU iptuResidencial,
    		final Logger log) {
    	
        kSession.setGlobal("logger", log);
        
        kSession.insert(iptuResidencial);        	
    	
    	int numRules = kSession.fireAllRules();
        
        log.info("Rules Fired: " + numRules);
    }
    
    public void execRegrasIPTUComercial (final IPTU iptuComercial,
    		final Logger log) {
    	
        kSession.setGlobal("logger", log);
        
        kSession.insert(iptuComercial);        	
    	
    	int numRules = kSession.fireAllRules();
        
        log.info("Rules Fired: " + numRules);
    }
 }
*/