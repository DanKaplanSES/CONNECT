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
package gov.hhs.fha.nhinc.docsubmission._20.entity;

import javax.annotation.Resource;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;

import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;

import gov.hhs.fha.nhinc.aspect.OutboundMessageEvent;
import gov.hhs.fha.nhinc.common.nhinccommonentity.RespondingGatewayProvideAndRegisterDocumentSetRequestType;
import gov.hhs.fha.nhinc.docsubmission.aspect.DocSubmissionArgTransformerBuilder;
import gov.hhs.fha.nhinc.docsubmission.aspect.DocSubmissionBaseEventDescriptionBuilder;
import gov.hhs.fha.nhinc.docsubmission.outbound.OutboundDocSubmission;

@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@Addressing(enabled = true)
public class EntityDocSubmissionUnsecured_g1 implements gov.hhs.fha.nhinc.nhincentityxdr.EntityXDRPortType {

    private WebServiceContext context;

    private OutboundDocSubmission outboundDocSubmission;

    @Override
    @OutboundMessageEvent(serviceType = "Document Submission", version = "2.0",
    beforeBuilder = DocSubmissionArgTransformerBuilder.class,
    afterReturningBuilder = DocSubmissionBaseEventDescriptionBuilder.class)
    public RegistryResponseType provideAndRegisterDocumentSetB(
            RespondingGatewayProvideAndRegisterDocumentSetRequestType body) {
        return new EntityDocSubmissionImpl_g1(outboundDocSubmission).provideAndRegisterDocumentSetBUnsecured(body, context);
    }

    @Resource
    public void setContext(WebServiceContext context) {
        this.context = context;
    }
    
    public void setOutboundDocSubmission(OutboundDocSubmission outboundDocSubmission) {
        this.outboundDocSubmission = outboundDocSubmission;
    }

    /**
     * Gets the outbound doc submission.
     *
     * @return the outbound doc submission
     */
    public OutboundDocSubmission getOutboundDocSubmission() {
        return this.outboundDocSubmission;
    }
}
