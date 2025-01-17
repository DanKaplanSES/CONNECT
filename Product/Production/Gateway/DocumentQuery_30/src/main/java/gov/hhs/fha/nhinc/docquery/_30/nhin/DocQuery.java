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
package gov.hhs.fha.nhinc.docquery._30.nhin;

import gov.hhs.fha.nhinc.aspect.InboundMessageEvent;
import gov.hhs.fha.nhinc.docquery.aspect.AdhocQueryRequestDescriptionBuilder;
import gov.hhs.fha.nhinc.docquery.aspect.AdhocQueryResponseDescriptionBuilder;
import gov.hhs.fha.nhinc.docquery.inbound.InboundDocQuery;
import ihe.iti.xds_b._2007.RespondingGatewayQueryPortType;

import javax.annotation.Resource;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;

import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;

/**
 * 
 * @author Neil Webb, msw
 */
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@Addressing(enabled = true)
public class DocQuery implements RespondingGatewayQueryPortType {
    
    private InboundDocQuery inboundDocQuery;
    private WebServiceContext context;

    /**
     * The web service implementation for Document Query.
     * 
     * @param body
     *            the body of the request
     * @return the query response for the document query
     */
    @InboundMessageEvent(beforeBuilder = AdhocQueryRequestDescriptionBuilder.class,
            afterReturningBuilder = AdhocQueryResponseDescriptionBuilder.class, serviceType = "Document Query",
            version = "3.0")
    public AdhocQueryResponse respondingGatewayCrossGatewayQuery(AdhocQueryRequest body) {
        return new DocQueryImpl(inboundDocQuery).respondingGatewayCrossGatewayQuery(body, context);
    }
    
    @Resource
    public void setContext(WebServiceContext context) {
        this.context = context;
    }

    public void setInboundDocQuery(InboundDocQuery inboundDocQuery) {
        this.inboundDocQuery = inboundDocQuery;
    }

    /**
     * Gets the inbound doc query dependency.
     *
     * @return the inbound doc query
     */
    public InboundDocQuery getInboundDocQuery() {
        return this.inboundDocQuery;
    }
}
