package com.insure.client;

import com.insure.client.gen.*;
import cryptography.Signature;

import javax.swing.*;
import javax.xml.ws.BindingProvider;
import java.lang.Exception;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/claimservice?wsdl"

public class Main {
    public static final String INSERT_CLAIM_ID = "Insert claim id: ";
    public static final String INSERT_DOCUMENT_ID = "Insert document id: ";

    public static void main(String[] args) throws Exception {
            Signature signature = new Signature();
            String url = "http://localhost:8090/claimservice";
            ClaimDataStoreService dss = new ClaimDataStoreService();
            //docStorage -> Claim data store
            ClaimDataStore docStorage = dss.getClaimDataStorePort();
            ((BindingProvider) docStorage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            // Client code
            String userId = JOptionPane.showInputDialog("Insert username: ", "user1");
            //auxiliary variables
            String[] options = {"create claim", "create document", "read document", "list documents",
                    "simulate document tampering", "exit"};
            int claimId;
            int documentId;

        clientLoop:
        while (true) {
            String expression = (String)JOptionPane.showInputDialog(null, "Insert your action:",
                    "You are " + userId, JOptionPane.QUESTION_MESSAGE, null, options, options[5]);

            try {
                switch (expression) {
                    case "create claim":

                        String claimDescription = JOptionPane.showInputDialog("Insert claim description: ");

                        claimId = docStorage.createClaim(claimDescription, userId);
                        JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));

                        break;
                    case "create document":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        String documentContent = JOptionPane.showInputDialog("Insert document content: ");

                        String digitalSignature = signature.generate(documentContent, "keys/" +
                                userId + "PrivateKey");
                        documentId = docStorage.createDocumentOfClaim(claimId, documentContent, userId,
                                digitalSignature);
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                                documentId));

                        break;
                    case "read document":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                                documentId));

                        break;
                    case "list documents":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));

                        printElements(docStorage.listDocumentsOfClaim(claimId).toArray(new String[0]));
                        JOptionPane.showMessageDialog(null, "Output in the terminal");

                        break;
                    case "simulate document tampering":
                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentContent = JOptionPane.showInputDialog("Insert document content: ");

                        digitalSignature = signature.generate(documentContent, "keys/" + userId +
                                "PrivateKey");
                        documentId = docStorage.createDocumentOfClaim(claimId, documentContent +
                                "this has been tampered", userId, digitalSignature);
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                                documentId));

                        break;
                    case "exit":
                        break clientLoop;
                }

            } catch (Exception e) {
                e.getMessage();
            }
        }

    }
        //utility method
        public static void printElements(String[] arr) {
            for (String el : arr) {
                System.out.println(el);
            }
        }
}


