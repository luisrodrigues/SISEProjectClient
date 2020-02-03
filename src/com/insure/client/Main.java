package com.insure.client;

import com.insure.client.gen.*;
import cryptography.Signature;

import javax.swing.*;
import javax.xml.ws.BindingProvider;
import java.lang.Exception;

public class Main {
        //Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/claimservice?wsdl"

        private static ClaimDataStore docStorage;

        public static void main(String[] args) throws Exception {
            System.out.println("Testing started");
            String url = "http://localhost:8090/claimservice";

            ClaimDataStoreService dss = new ClaimDataStoreService();

            docStorage = dss.getClaimDataStorePort();

            ((BindingProvider) docStorage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            String userId = "user1";
            //Signature signature = new Signature();

            int claimId = docStorage.createClaim("accident1");
            Claim claim = docStorage.retrieveClaim(claimId);

            System.out.println(claimId);
            System.out.println(claim.toString()); // <- show print attributes
            System.out.println("Testing finished");

            /*
            docStorage.updateClaim(claimId, "accident2");
            System.out.println(claim.toString());

            String digitalSignature = signature.generate(claim.toString(), "keys/" + userId + "PrivateKey");
            int documentId = docStorage.createDocumentOfClaim(claimId, "medical report", userId, digitalSignature);
            System.out.println(docStorage.readDocumentOfClaim(claimId, documentId, userId));
            */


        }

        /*while (true) {
        String expression = JOptionPane.showInputDialog("Insert expression: ");
        try {
            if (expression.equals("exit")) {
                break;
            }
            int res = eval(expression, calc);
            JOptionPane.showMessageDialog(null, "result is: " + res);
        } catch (Exception e) {

        }*/
}


