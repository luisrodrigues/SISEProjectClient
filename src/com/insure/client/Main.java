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
            String userId = JOptionPane.showInputDialog("Insert username: ");
            //auxiliary variables
            int claimId;
            int documentId;

        label:
        while (true) {
            String expression = JOptionPane.showInputDialog("Insert expression (create/update claim) or (list documents or create/read/update/delete document)");

            try {
                switch (expression) {
                    case "exit":
                        break label;
                    case "create claim":

                        String claimDescription = JOptionPane.showInputDialog("Insert claim description: ");

                        claimId = docStorage.createClaim(claimDescription, userId);
                        JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));

                        break;
                    case "update claim":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        String newClaimDescription = JOptionPane.showInputDialog("Insert new claim description: ");

                        docStorage.updateClaim(claimId, newClaimDescription);
                        JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));

                        break;
                    case "list documents":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));

                        printElements(docStorage.listDocumentsOfClaim(claimId).toArray(new String[0]));
                        JOptionPane.showMessageDialog(null, "Output in the command line");

                        break;
                    case "create document":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        String documentContent = JOptionPane.showInputDialog("Insert document content: ");

                        documentId = docStorage.createDocumentOfClaim(claimId, documentContent, userId);
                        String digitalSignature = signature.generate(docStorage.readDocumentOfClaim(claimId, documentId), "keys/" + userId + "PrivateKey");
                        docStorage.signDocumentOfClaim(claimId, documentId, digitalSignature);
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId, documentId));

                        break;
                    case "read document":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId, documentId));

                        break;
                    case "update document":

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
                        String newDocumentContent = JOptionPane.showInputDialog("Insert new document content: ");

                        docStorage.updateDocumentOfClaim(claimId, documentId, newDocumentContent, userId);
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId, documentId));

                        break;
                    case "delete document":
                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

                        docStorage.deleteDocumentOfClaim(claimId, documentId, userId);
                        printElements(docStorage.listDocumentsOfClaim(claimId).toArray(new String[0]));
                        JOptionPane.showMessageDialog(null, "Output in the command line");

                        break;
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


