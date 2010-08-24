/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.hhs.fha.nhinc.patientdiscovery.adapter.deferred.response;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author JHOPPESC
 */
@WebService(serviceName = "AdapterPatientDiscoveryAsyncResp", portName = "AdapterPatientDiscoveryAsyncRespPortSoap", endpointInterface = "gov.hhs.fha.nhinc.adapterpatientdiscoveryasyncresp.AdapterPatientDiscoveryAsyncRespPortType", targetNamespace = "urn:gov:hhs:fha:nhinc:adapterpatientdiscoveryasyncresp", wsdlLocation = "WEB-INF/wsdl/AdapterPatientDiscoveryDeferredResponseUnsecured/AdapterPatientDiscoveryAsyncResp.wsdl")
@BindingType(value = "http://www.w3.org/2003/05/soap/bindings/HTTP/")
public class AdapterPatientDiscoveryDeferredResponseUnsecured {
    @Resource
    private WebServiceContext context;

    public org.hl7.v3.MCCIIN000002UV01 processPatientDiscoveryAsyncResp(org.hl7.v3.RespondingGatewayPRPAIN201306UV02RequestType processPatientDiscoveryAsyncRespAsyncRequest) {
        return new AdapterPatientDiscoverySecuredDeferredResponseImpl().processPatientDiscoveryAsyncResp(processPatientDiscoveryAsyncRespAsyncRequest.getPRPAIN201306UV02(), processPatientDiscoveryAsyncRespAsyncRequest.getAssertion(), context);
    }

}