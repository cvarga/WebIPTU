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

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.runtime.KieSession;

@XmlRootElement
public abstract class IPTU {
	
	private int metrosQuadrados;
	private float valorVenal;
	
	private float valorIPTU;
	private float porcentagemAplicada;
	private float deducao;
	
	@XmlTransient
    private final KieSession kSession;
	
	@XmlTransient
	final RuleNameStartsWithAgendaFilter ruleAgenda;
	
    private int rulesFired;
	
	protected IPTU(final KieSession kSession, final RuleNameStartsWithAgendaFilter ruleAgenda) {
		this.kSession = kSession;
		this.ruleAgenda = ruleAgenda;
	}
	
	protected void calcularIptu(int metrosQuadrados, float valorVenal){
		
		this.valorVenal = valorVenal;
		this.metrosQuadrados = metrosQuadrados;

		kSession.insert(this);		
		rulesFired = kSession.fireAllRules(ruleAgenda);
	}
	/**
	 * Desaloca o motor de regras (Permite o GC efetuar o flush de mem no BRMS)
	 */
	public void dispose() {
		kSession.dispose();
	}
	
	public int getMetrosQuadrado() {
		return metrosQuadrados;
	}

	public float getValorIPTU() {
		return valorIPTU;
	}

	public void setValorIPTU(float valorIPTU) {
		this.valorIPTU = valorIPTU;
	}

	public float getValorVenal() {
		return valorVenal;
	}

	public void setValorVenal(float valorVenal) {
		this.valorVenal = valorVenal;
	}

	public float getPorcentagemValor() {
		return porcentagemAplicada;
	}

	public void setPorcentagemValor(float porcentagemValor) {
		this.porcentagemAplicada = porcentagemValor;
	}

	public float getDeducao() {
		return deducao;
	}

	public void setDeducao(float deducao) {
		this.deducao = deducao;
	}

	@Override
	public String toString() {
		return "IPTU [metrosQuadrado=" + metrosQuadrados + ", valorVenal="
				+ valorVenal + ", valorIPTU=" + valorIPTU
				+ ", porcentagemAplicada=" + porcentagemAplicada + ", deducao="
				+ deducao + "]";
	}

	public int getRulesFired() {
		return rulesFired;
	}

	public void setRulesFired(int rulesFired) {
		this.rulesFired = rulesFired;
	}
	
	
}
