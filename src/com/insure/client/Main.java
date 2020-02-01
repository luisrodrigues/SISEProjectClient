package com.insure.client;

import com.insure.client.gen.ClaimDataStore;
import com.insure.client.gen.ClaimDataStoreService;

import javax.xml.ws.BindingProvider;
import java.io.IOException;

public class Main {
        //Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/claimservice?wsdl"
        private static ClaimDataStore docStorage;

        public static void main(String[] args) throws IOException {
            String url = "http://localhost:8090/claimservice";

            ClaimDataStoreService dss = new ClaimDataStoreService();

            docStorage = dss.getClaimDataStorePort();

            ((BindingProvider) docStorage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
            Integer claim_id = docStorage.createClaim();

            System.out.println("Claim id created:"+ claim_id);
        }
}