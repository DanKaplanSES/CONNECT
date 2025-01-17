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
package gov.hhs.fha.nhinc.docsubmission.nhin.deferred.request.proxy11;

import gov.hhs.fha.nhinc.aspect.NwhinInvocationEvent;
import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetSystemType;
import gov.hhs.fha.nhinc.docsubmission.DocSubmissionUtils;
import gov.hhs.fha.nhinc.docsubmission.MessageGeneratorUtils;
import gov.hhs.fha.nhinc.docsubmission.aspect.DocSubmissionBaseEventDescriptionBuilder;
import gov.hhs.fha.nhinc.docsubmission.nhin.deferred.request.proxy11.service.NhinDocSubmissionDeferredRequestServicePortDescriptor;
import gov.hhs.fha.nhinc.largefile.LargePayloadException;
import gov.hhs.fha.nhinc.messaging.client.CONNECTClient;
import gov.hhs.fha.nhinc.messaging.client.CONNECTClientFactory;
import gov.hhs.fha.nhinc.messaging.service.port.ServicePortDescriptor;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants.GATEWAY_API_LEVEL;
import gov.hhs.fha.nhinc.webserviceproxy.WebServiceProxyHelper;
import gov.hhs.healthit.nhin.XDRAcknowledgementType;
import ihe.iti.xdr._2007.XDRDeferredRequestPortType;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;

import org.apache.log4j.Logger;

public class NhinDocSubmissionDeferredRequestProxyWebServiceSecuredImpl implements
        NhinDocSubmissionDeferredRequestProxy {
    private static final Logger LOG = Logger.getLogger(NhinDocSubmissionDeferredRequestProxyWebServiceSecuredImpl.class);
    private WebServiceProxyHelper oProxyHelper = null;

    public NhinDocSubmissionDeferredRequestProxyWebServiceSecuredImpl() {
        oProxyHelper = createWebServiceProxyHelper();
    }

    protected DocSubmissionUtils getDocSubmissionUtils() {
        return DocSubmissionUtils.getInstance();
    }

    protected MessageGeneratorUtils getMessageGeneratorUtils() {
        return MessageGeneratorUtils.getInstance();
    }

    protected WebServiceProxyHelper createWebServiceProxyHelper() {
        return new WebServiceProxyHelper();
    }

    protected CONNECTClient<XDRDeferredRequestPortType> getCONNECTClientSecured(
            ServicePortDescriptor<XDRDeferredRequestPortType> portDescriptor, String url, AssertionType assertion, 
                       String target, String serviceName) {
        CONNECTClient<XDRDeferredRequestPortType> client =  CONNECTClientFactory.getInstance().getCONNECTClientSecured(portDescriptor, assertion, url, target, 
                serviceName);
        return client;
    }

    @Override
    @NwhinInvocationEvent(beforeBuilder = DocSubmissionBaseEventDescriptionBuilder.class,
    afterReturningBuilder = DocSubmissionBaseEventDescriptionBuilder.class, 
    serviceType = "Document Submission Deferred Request",
    version = "")
    public XDRAcknowledgementType provideAndRegisterDocumentSetBRequest11(
            ProvideAndRegisterDocumentSetRequestType request, AssertionType assertion, NhinTargetSystemType targetSystem) {
        LOG.debug("Begin provideAndRegisterDocumentSetBAsyncRequest");
        XDRAcknowledgementType response = null;

        try {
            if (request == null) {
                LOG.error("Message was null");
            } else {
                String url = oProxyHelper.getUrlFromTargetSystemByGatewayAPILevel(targetSystem,
                        NhincConstants.NHINC_XDR_REQUEST_SERVICE_NAME, GATEWAY_API_LEVEL.LEVEL_g0);
                getDocSubmissionUtils().convertFileLocationToDataIfEnabled(request);

                ServicePortDescriptor<XDRDeferredRequestPortType> portDescriptor = new NhinDocSubmissionDeferredRequestServicePortDescriptor();
                CONNECTClient<XDRDeferredRequestPortType> client = getCONNECTClientSecured(portDescriptor, url,
                        assertion, targetSystem.getHomeCommunity().getHomeCommunityId(), 
                        NhincConstants.NHINC_XDR_REQUEST_SERVICE_NAME );
                client.enableMtom();

                response = (XDRAcknowledgementType) client.invokePort(XDRDeferredRequestPortType.class,
                        "provideAndRegisterDocumentSetBDeferredRequest", request);
            }
        } catch (LargePayloadException lpe) {
            LOG.error("Failed to send message.", lpe);
            response = getMessageGeneratorUtils().createMissingDocumentXDRAcknowledgementType();
        } catch (Exception ex) {
            LOG.error("Error calling provideAndRegisterDocumentSetBDeferredRequest: " + ex.getMessage(), ex);
            response = getMessageGeneratorUtils().createRegistryErrorXDRAcknowledgementType(ex.getMessage());
        }

        LOG.debug("End provideAndRegisterDocumentSetBAsyncRequest");
        return response;
    }

}
