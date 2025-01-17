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
package gov.hhs.fha.nhinc.docquery.adapter.proxy;

import gov.hhs.fha.nhinc.adapterdocquerysecured.AdapterDocQuerySecuredPortType;
import gov.hhs.fha.nhinc.aspect.AdapterDelegationEvent;
import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.docquery.adapter.proxy.description.AdapterDocQuerySecuredServicePortDescriptor;
import gov.hhs.fha.nhinc.docquery.aspect.AdhocQueryRequestDescriptionBuilder;
import gov.hhs.fha.nhinc.docquery.aspect.AdhocQueryResponseDescriptionBuilder;
import gov.hhs.fha.nhinc.messaging.client.CONNECTClient;
import gov.hhs.fha.nhinc.messaging.client.CONNECTClientFactory;
import gov.hhs.fha.nhinc.messaging.service.port.ServicePortDescriptor;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants;
import gov.hhs.fha.nhinc.nhinclib.NullChecker;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import org.apache.log4j.Logger;

/**
 *
 *
 * @author Neil Webb
 */
public class AdapterDocQueryProxyWebServiceSecuredImpl extends BaseAdapterDocQueryProxy {

    private static final Logger LOG = Logger.getLogger(AdapterDocQueryProxyJavaImpl.class);

    /**
     * @param apiLevel Adapter ApiLevel Param.
     * @return Adapter apiLevel implementation to be used (a0 or a1 level).
     */
    public ServicePortDescriptor<AdapterDocQuerySecuredPortType> getServicePortDescriptor(
        NhincConstants.ADAPTER_API_LEVEL apiLevel) {
        switch (apiLevel) {
            case LEVEL_a0:
                return new AdapterDocQuerySecuredServicePortDescriptor();
            default:
                return new AdapterDocQuerySecuredServicePortDescriptor();
        }
    }

    /**
     * The respondingGatewayCrossGatewayQuery method returns AdhocQueryResponse from Adapter interface.
     *
     * @param msg The AdhocQueryRequest message.
     * @param assertion Assertion received.
     * @return AdhocQuery Response from Adapter interface.
     */
    @AdapterDelegationEvent(beforeBuilder = AdhocQueryRequestDescriptionBuilder.class,
    afterReturningBuilder = AdhocQueryResponseDescriptionBuilder.class, serviceType = "Document Query",
    version = "")
    @Override
    public AdhocQueryResponse respondingGatewayCrossGatewayQuery(AdhocQueryRequest msg, AssertionType assertion) {
        AdhocQueryResponse response = null;
        String url = null;
        try {
            //get the Adopter Endpoint URL
            url = getEndPointFromConnectionManagerByAdapterAPILevel(assertion,NhincConstants.ADAPTER_DOC_QUERY_SECURED_SERVICE_NAME);

            //Call the service
            if (NullChecker.isNotNullish(url)) {
                if (msg == null) {
                    LOG.error("Message was null");
                } else {
                    ServicePortDescriptor<AdapterDocQuerySecuredPortType> portDescriptor = getServicePortDescriptor(NhincConstants.ADAPTER_API_LEVEL.LEVEL_a0);

                    CONNECTClient<AdapterDocQuerySecuredPortType> client = CONNECTClientFactory.getInstance()
                        .getCONNECTClientSecured(portDescriptor, url, assertion);

                    response = (AdhocQueryResponse) client.invokePort(AdapterDocQuerySecuredPortType.class,
                        "respondingGatewayCrossGatewayQuery", msg);
                }
            } else {
                LOG.error("Failed to call the web service (" + NhincConstants.ADAPTER_DOC_QUERY_SECURED_SERVICE_NAME
                    + ").  The URL is null.");
            }
        } catch (Exception ex) {
            LOG.error("Error sending Adapter Doc Query Secured message: " + ex.getMessage(), ex);
            response = getAdapterHelper().createErrorResponse();
        }

        return response;
    }
}
