/*
 * Copyright (c) 2012, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.hhs.fha.nhinc.patientdiscovery._10.gateway.ws;

import static org.junit.Assert.assertNotNull;
import gov.hhs.fha.nhinc.patientdiscovery.inbound.deferred.request.PassthroughInboundPatientDiscoveryDeferredRequest;
import gov.hhs.fha.nhinc.patientdiscovery.inbound.deferred.request.StandardInboundPatientDiscoveryDeferredRequest;
import gov.hhs.fha.nhinc.patientdiscovery.outbound.deferred.request.PassthroughOutboundPatientDiscoveryDeferredRequest;
import gov.hhs.fha.nhinc.patientdiscovery.outbound.deferred.request.StandardOutboundPatientDiscoveryDeferredRequest;

import org.hl7.v3.MCCIIN000002UV01;
import org.hl7.v3.PRPAIN201305UV02;
import org.hl7.v3.RespondingGatewayPRPAIN201305UV02RequestType;
import org.hl7.v3.RespondingGatewayPRPAIN201305UV02SecuredRequestType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author akong
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/patientdiscovery/_10/applicationContext.xml" })
public class PatientDiscoveryDeferredRequestSpringContextTest {

    @Autowired
    NhinPatientDiscoveryDeferredRequest inboundPatientDiscoveryEndpoint;
    
    @Autowired
    EntityPatientDiscoveryDeferredRequestUnsecured outboundPatientDiscoveryUnsecuredEndpoint;
    
    @Autowired
    EntityPatientDiscoveryDeferredRequestSecured outboundPatientDiscoverySecuredEndpoint;
    
    @Autowired
    StandardOutboundPatientDiscoveryDeferredRequest stdOutboundReqOrchImpl;
    
    @Autowired
    StandardInboundPatientDiscoveryDeferredRequest stdInboundReqOrchImpl;
    
    @Autowired
    PassthroughOutboundPatientDiscoveryDeferredRequest ptOutboundPDResqOrchImpl;
    
    @Autowired
    PassthroughInboundPatientDiscoveryDeferredRequest ptInboundPDReqOrchImpl;
   

    @Test
    public void inbound() {
        assertNotNull(inboundPatientDiscoveryEndpoint);

        PRPAIN201305UV02 request = new PRPAIN201305UV02();
        MCCIIN000002UV01 response = inboundPatientDiscoveryEndpoint.respondingGatewayDeferredPRPAIN201305UV02(request);

        assertNotNull(response);
    }
    
    @Test
    public void outboundUnsecured() {
        assertNotNull(outboundPatientDiscoveryUnsecuredEndpoint);
        
        RespondingGatewayPRPAIN201305UV02RequestType request = new RespondingGatewayPRPAIN201305UV02RequestType();
        MCCIIN000002UV01 response = outboundPatientDiscoveryUnsecuredEndpoint.processPatientDiscoveryAsyncReq(request);
        
        assertNotNull(response);
    }
    
    @Test
    public void outboundSecured() {
        assertNotNull(outboundPatientDiscoverySecuredEndpoint);
        
        RespondingGatewayPRPAIN201305UV02SecuredRequestType request = new RespondingGatewayPRPAIN201305UV02SecuredRequestType();
        MCCIIN000002UV01 response = outboundPatientDiscoverySecuredEndpoint.processPatientDiscoveryAsyncReq(request);
        
        assertNotNull(response);
    }
}
