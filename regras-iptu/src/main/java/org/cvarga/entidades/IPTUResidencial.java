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
package org.cvarga.entidades;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.jboss.logging.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class IPTUResidencial extends IPTU {
	
	private IPTUResidencial(final KieSession kSession, final RuleNameStartsWithAgendaFilter agenda  ) {
		super(kSession,agenda);
	}
	
	public static IPTUResidencial buildIPTU(int ano) {
		
		String kieSessionName = "IPTU" + ano;
		String rulesStartsWith = "RES";
		
		//Monta a sessao no BRMS
		final KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
		final KieSession kSession  = kc.newKieSession(kieSessionName);
		
		if(kSession == null)
			throw new IllegalArgumentException("Falha ao montar sessao de conhecimento para o ano de : "+ ano + " KieSession:" + kieSessionName);
		
		//Atribui um logger ao BRMS
		Logger log = Logger.getLogger(IPTUResidencial.class);
		kSession.setGlobal("logger", log);
		
		//Monta as regras específicas do imposto residencial (Quando houver RES no início da regra)
		final RuleNameStartsWithAgendaFilter agenda = new RuleNameStartsWithAgendaFilter(rulesStartsWith);
		
		final IPTUResidencial iptuResidencial = 
				new IPTUResidencial(kSession,agenda);
		
		return iptuResidencial;
	}
	
	public void calcularIptu(final int metrosQuadrados, final float valorVenal) {
		
		if(metrosQuadrados == 0 || valorVenal == 0f)
			throw new IllegalArgumentException("Parametro de construcao invalido.");
		
		super.calcularIptu(metrosQuadrados,valorVenal);
	}

}
